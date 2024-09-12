package jsclub.codefest2024.bot;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.Hero;
import jsclub.codefest2024.sdk.algorithm.PathUtils;
import jsclub.codefest2024.sdk.base.Node;
import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.model.enemies.Enemy;
import jsclub.codefest2024.sdk.model.equipments.HealingItem;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;
import jsclub.codefest2024.sdk.model.players.Player;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SERVER_URL = "https://cf-server.jsclub.dev";
    private static final String GAME_ID = "121265";
    private static final String PLAYER_NAME = "sondeptrai";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {

                try {
                    GameMap gameMap = hero.getGameMap();
                    Player player = gameMap.getCurrentPlayer();
                    gameMap.updateOnUpdateMap(args[0], player, hero);


                    List<Node> nodes = new ArrayList<>();

                    List<Obstacle> chests = gameMap.getListChests();
                    for (Obstacle chest : chests) {
                        nodes.add((Node) chest);
                    }

                    List<Obstacle> traps = gameMap.getListTraps();
                    for (Obstacle trap : traps) {
                        nodes.add((Node) trap);
                    }

                    List<Obstacle> obstacles = gameMap.getListIndestructibleObstacles();
                    for (Obstacle obstacle : obstacles) {
                        nodes.add((Node) obstacle);
                    }

                    String path = PathUtils.getShortestPath(
                            gameMap,
                            nodes,
                            player,
                            getNearestGun(gameMap, gameMap.getCurrentPlayer()),
                            false
                    );


                    if (hero.getInventory().getGun() == null) {
                        hero.move(path);

                        List<Weapon> guns = gameMap.getAllGun();
                        for (Weapon gun : guns) {
                            if (gun.x == player.x && gun.y == player.y) {
                                hero.pickupItem();
                            }
                        }
                    } else {
                        String path2 = PathUtils.getShortestPath(
                                gameMap,
                                nodes,
                                player,
                                getNestestEnemy(gameMap, player),
                                true
                        );
                        hero.move(path2);
                    }

                    System.out.println("GUN: " + hero.getInventory().getGun());
                    System.out.println("MELEE: " + hero.getInventory().getMelee());
                    System.out.println("THROWABLE: " + hero.getInventory().getThrowable());
                    System.out.println("ARMOR: " + hero.getInventory().getListArmor());
                    System.out.println("HEALING: " + hero.getInventory().getListHealingItem());


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }

    private static Weapon getNearestGun(GameMap gameMap, Player player) {
        List<Weapon> guns = gameMap.getAllGun();
        Weapon target = guns.get(0);
        double distance = 10000000;
        for (Weapon weapon : guns) {
            if (distance > (player.x - weapon.x) * (player.x - weapon.x)
                    + (player.y - weapon.y) * (player.y - weapon.y)) {
                distance = (player.x - weapon.x) * (player.x - weapon.x)
                        + (player.y - weapon.y) * (player.y - weapon.y);
                target = weapon;
            }
        }
        return target;
    }

    private static Weapon getNearestMelee(GameMap gameMap, Player player) {
        List<Weapon> melees = gameMap.getAllMelee();
        Weapon target = melees.get(0);
        double distance = 10000000;
        for (Weapon weapon : melees) {
            if (distance > (player.x - weapon.x) * (player.x - weapon.x)
                    + (player.y - weapon.y) * (player.y - weapon.y)) {
                distance = (player.x - weapon.x) * (player.x - weapon.x)
                        + (player.y - weapon.y) * (player.y - weapon.y);
                target = weapon;
            }
        }
        return target;
    }

    private static Weapon getNearestThrowable(GameMap gameMap, Player player) {
        List<Weapon> throwable = gameMap.getAllThrowable();
        Weapon target = throwable.get(0);
        double distance = 10000000;
        for (Weapon weapon : throwable) {
            if (distance > (player.x - weapon.x) * (player.x - weapon.x)
                    + (player.y - weapon.y) * (player.y - weapon.y)) {
                distance = (player.x - weapon.x) * (player.x - weapon.x)
                        + (player.y - weapon.y) * (player.y - weapon.y);
                target = weapon;
            }
        }
        return target;
    }

    private static HealingItem getNearestHealing(GameMap gameMap, Player player) {
        List<HealingItem> healingItems = gameMap.getListHealingItems();
        HealingItem target = healingItems.get(0);
        double distance = 10000000;
        for (HealingItem healing : healingItems) {
            if (distance > (player.x - healing.x) * (player.x - healing.x)
                    + (player.y - healing.y) * (player.y - healing.y)) {
                distance = (player.x - healing.x) * (player.x - healing.x)
                        + (player.y - healing.y) * (player.y - healing.y);
                target = healing;
            }
        }
        return target;
    }

    private static Obstacle getNearestChest(GameMap gameMap, Player player) {
        List<Obstacle> chests = gameMap.getListChests();
        Obstacle target = chests.get(0);
        double distance = 10000000;
        for (Obstacle chest : chests) {
            if (distance > (player.x - chest.x) * (player.x - chest.x)
                    + (player.y - chest.y) * (player.y - chest.y)) {
                distance = (player.x - chest.x) * (player.x - chest.x)
                        + (player.y - chest.y) * (player.y - chest.y);
                target = chest;
            }
        }
        return target;
    }

    private static Player getNearestPlayer(GameMap gameMap, Player player) {
        List<Player> players = gameMap.getOtherPlayerInfo();
        Player target = players.get(0);
        double distance = 10000000;
        for (Player otherPlayer : players) {
            if (distance > (player.x - otherPlayer.x) * (player.x - otherPlayer.x)
                    + (player.y - otherPlayer.y) * (player.y - otherPlayer.y)) {
                distance = (player.x - otherPlayer.x) * (player.x - otherPlayer.x)
                        + (player.y - otherPlayer.y) * (player.y - otherPlayer.y);
                target = otherPlayer;
            }
        }
        return target;
    }

    private static Enemy getNestestEnemy(GameMap gameMap, Player player) {
        List<Enemy> enemies = gameMap.getListEnemies();
        Enemy target = enemies.get(0);
        double distance = 10000000;
        for (Enemy enemy : enemies) {
            if (distance > (player.x - enemy.x) * (player.x - enemy.x)
                    + (player.y - enemy.y) * (player.y - enemy.y)) {
                distance = (player.x - enemy.x) * (player.x - enemy.x)
                        + (player.y - enemy.y) * (player.y - enemy.y);
                target = enemy;
            }
        }
        return target;
    }

    private static int getDistance(GameMap gameMap, Element element1, Element element2) {
        String path = PathUtils.getShortestPath(
                gameMap,
                List.of(),
                element1,
                element2,
                false
        );
        return path.length();
    }

}
