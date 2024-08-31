package jsclub.codefest2024.bot;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.algorithm.ShortestPath;
import jsclub.codefest2024.sdk.base.Node;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.Hero;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;
import jsclub.codefest2024.sdk.model.players.Player;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final String SERVER_URL = "https://cf-server.jsclub.dev";
    private static final String GAME_ID = "131546";
    private static final String PLAYER_NAME = "ptd1";

    public static String randomMove() {
        String[] moves = {"u", "d", "l", "r"};
        return moves[(int) (Math.random() * moves.length)];
    }

    static boolean gotWeapon = false;

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try {
                    GameMap gameMap = hero.getGameMap();
                    gameMap.updateOnUpdateMap(args[0]);

                    Player player = gameMap.getCurrentPlayer();

                    if (!player.getIsAlive()) {
                        gotWeapon = false;
                    }

                    Obstacle nearestChest = getNearestChest(gameMap, player);
                    Player nearestPlayer = getNearestPlayer(gameMap, player);
                    Weapon nearestWeapon = getNearestMelee(gameMap, player);

                    if (!gotWeapon) {
                        if (nearestWeapon == null) {
                            if (attackAble(nearestChest, player, 1)) {
                                hero.attack(getRelativeDirection(nearestChest, player));
                            }
                            else {
                                hero.move(
                                        ShortestPath.getShortestPath(
                                                gameMap,
                                                gameMap.getListEnemies()
                                                        .stream()
                                                        .map(enemy -> new Node(enemy.x, enemy.y))
                                                        .toList(),
                                                player,
                                                nearestChest,
                                                true
                                        )
                                );
                            }
                        } else {
                            if (reach(nearestWeapon, player)) {
                                hero.pickupItem();
                                gotWeapon = true;
                            }
                            else {
                                hero.move(
                                        ShortestPath.getShortestPath(
                                                gameMap,
                                                gameMap.getListChests()
                                                        .stream()
                                                        .map(enemy -> new Node(enemy.x, enemy.y))
                                                        .toList(),
                                                player,
                                                nearestWeapon,
                                                true
                                        )
                                );
                            }
                        }
                    } else {
                        if (attackAble(nearestPlayer, player, hero.getInventory().getMelee().getRange())) {
                            hero.attack(getRelativeDirection(nearestPlayer, player));
                        }
                        else {
                            hero.move(
                                    ShortestPath.getShortestPath(
                                            gameMap,
                                            gameMap.getListChests()
                                                    .stream()
                                                    .map(enemy -> new Node(enemy.x, enemy.y))
                                                    .toList(),
                                            player,
                                            nearestPlayer,
                                            true
                                    )
                            );
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }

    private static String getRelativeDirection(Node x, Node y) {
        if (x.x == y.x) {
            if (x.y > y.y) return "u";
            else return "d";
        }

        if (x.y == y.y) {
            if (x.x > y.x) return "r";
            else return "l";
        }

        return "r";
    }

    private static boolean reach(Node x, Node y) {
        return x.x == y.x && x.y == y.y;
    }

    private static boolean attackAble(Node x, Node y, int range) {
        return Math.sqrt(Math.pow(x.x - y.x, 2) + Math.pow(x.y - y.y, 2)) <= (double) range;
    }

    private static Obstacle getNearestChest(GameMap gameMap, Player player) {
        List<Obstacle> chests = gameMap.getListChests();

        if (chests.isEmpty()) return null;

        Obstacle chest = chests.get(0);
        double distance = 10000000;
        for (Obstacle obstacle : chests) {
            double curDis = ShortestPath.getShortestPath(
                    gameMap,
                    gameMap.getListEnemies()
                            .stream()
                            .map(enemy -> new Node(enemy.x, enemy.y))
                            .toList(),
                    player,
                    obstacle,
                    true
            ).length();

            if (distance > curDis) {
                distance = curDis;
                chest = obstacle;
            }
        }

        return chest;
    }

    private static Player getNearestPlayer(GameMap gameMap, Player player) {
        List<Player> players = gameMap
                .getOtherPlayerInfo()
                .stream()
                .filter(Player::getIsAlive)
                .toList();

        if (players.isEmpty()) return null;

        Player target = players.get(0);
        double distance = 10000000;
        for (Player otherPlayer : players) {
            double curDis = ShortestPath.getShortestPath(
                    gameMap,
                    gameMap.getListEnemies()
                            .stream()
                            .map(enemy -> new Node(enemy.x, enemy.y))
                            .toList(),
                    player,
                    otherPlayer,
                    true
            ).length();

            if (distance > curDis) {
                distance = curDis;
                target = otherPlayer;
            }
        }

        return target;
    }

    private static Weapon getNearestMelee(GameMap gameMap, Player player) {
        List<Weapon> melees = gameMap.getAllMelee();

        if (melees.isEmpty()) return null;

        Weapon target = null;
        double distance = 10000000;
        for (Weapon weapon : melees) if (Objects.equals(weapon.getId(), "SANDAL")) {
            double curDis = ShortestPath.getShortestPath(
                    gameMap,
                    gameMap.getListEnemies()
                            .stream()
                            .map(enemy -> new Node(enemy.x, enemy.y))
                            .toList(),
                    player,
                    weapon,
                    true
            ).length();

            if (distance > curDis) {
                distance = curDis;
                target = weapon;
            }
        }
        return target;
    }
}
