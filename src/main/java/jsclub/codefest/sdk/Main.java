package jsclub.codefest.sdk;

import io.socket.emitter.Emitter;
import jsclub.codefest.sdk.algorithm.PathUtils;
import jsclub.codefest.sdk.base.Node;
import jsclub.codefest.sdk.model.GameMap;
import jsclub.codefest.sdk.model.obstacles.Obstacle;
import jsclub.codefest.sdk.model.players.Player;
import jsclub.codefest.sdk.model.weapon.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // --- THÔNG TIN CẤU HÌNH (Lấy từ code base mới) ---
    private static final String SERVER_URL = "https://cf25-server-staging.jsclub.dev";
    private static final String GAME_ID = "185440";
    private static final String PLAYER_NAME = "phi";
    private static final String SECRET_KEY = "sk-eBxDjEN1RHOSiq5Dp1Y2UA:_ubE3ufCS9UO562iLFTNSqcK5vxAl93EWMvfFrvxyFrgcw5MVz3gd3I-8TONOIocQvuZx4mqtxyfBSV8xUpNNQ";

    public static void main(String[] args) throws IOException {
        // Sử dụng SECRET_KEY từ code base mới
        Hero hero = new Hero(GAME_ID, PLAYER_NAME, SECRET_KEY);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try {
                    GameMap gameMap = hero.getGameMap();
                    gameMap.updateOnUpdateMap(args[0]);
                    Player player = gameMap.getCurrentPlayer();

                    // --- THU THẬP THÔNG TIN MÔI TRƯỜNG ---
                    // 1. Tạo danh sách các vật cản cần tránh khi tìm đường
                    List<Node> nodesToAvoid = getNodeNeedToAvoid(gameMap);

                    // 2. Tìm đường đến người chơi gần nhất
                    String pathToGun = findPathToGun(gameMap, nodesToAvoid, player);

                    if (pathToGun != null) {
                        System.out.println("di den ke dich");
                        hero.move(pathToGun);
                        if (pathToGun.length() == 1) {
                            hero.attack(pathToGun);
                        }
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    System.err.println("Một lỗi không mong muốn đã xảy ra: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }

    private static List<Node> getNodeNeedToAvoid(GameMap gameMap) {
        List<Node> nodes = new ArrayList<>();
        for (Obstacle obstacle : gameMap.getListIndestructibleObstacles()) {
            nodes.add(obstacle);
        }
        for (Player player : gameMap.getOtherPlayerInfo()) {
            nodes.add(player);
        }
        return nodes;
    }

    private static String findPathToOtherPlayer(GameMap gameMap, List<Node> nodes, Player player) {
        Player nearestPlayer = getNearestPlayer(gameMap, player);
        if (nearestPlayer == null) {
            return null;
        }
        List<Node> tempNodes = new ArrayList<>(nodes);
        tempNodes.remove(nearestPlayer);
        return PathUtils.getShortestPath(gameMap, tempNodes, player, nearestPlayer, false);
    }

    private static String findPathToGun(GameMap gameMap, List<Node> nodes, Player player) {
        if (gameMap.getAllGun().isEmpty()) {
            return null;
        }
        Weapon nearestGun = getNearestGun(gameMap, player);
        return PathUtils.getShortestPath(gameMap, nodes, player, nearestGun, false);
    }

    private static String findPathToMelee(GameMap gameMap, List<Node> nodes, Player player) {
        if (gameMap.getAllMelee().isEmpty()) {
            return null;
        }
        Weapon nearestMelee = getNearestMelee(gameMap, player);
        return PathUtils.getShortestPath(gameMap, nodes, player, nearestMelee, false);
    }

    private static Player getNearestPlayer(GameMap gameMap, Player player) {
        List<Player> otherPlayers = gameMap.getOtherPlayerInfo();
        Player target = null;
        double minDistance = Double.MAX_VALUE;
        for (Player otherPlayer : otherPlayers) {
            // Chỉ tìm những người chơi còn sống
            double distance = Math.pow(player.x - otherPlayer.x, 2) + Math.pow(player.y - otherPlayer.y, 2);
            if (distance < minDistance) {
                minDistance = distance;
                target = otherPlayer;
            }

        }
        return target;
    }

    private static Weapon getNearestGun(GameMap gameMap, Player player) {
        List<Weapon> guns = gameMap.getAllGun();
        Weapon target = null;
        double minDistance = Double.MAX_VALUE;
        for (Weapon weapon : guns) {
            double distance = Math.pow(player.x - weapon.x, 2) + Math.pow(player.y - weapon.y, 2);
            if (distance < minDistance) {
                minDistance = distance;
                target = weapon;
            }
        }
        return target;
    }

    private static Weapon getNearestMelee(GameMap gameMap, Player player) {
        List<Weapon> melees = gameMap.getAllMelee();
        Weapon target = null;
        double minDistance = Double.MAX_VALUE;
        for (Weapon weapon : melees) {
            double distance = Math.pow(player.x - weapon.x, 2) + Math.pow(player.y - weapon.y, 2);
            if (distance < minDistance) {
                minDistance = distance;
                target = weapon;
            }
        }
        return target;
    }

    public static String checkString(String path, int range) {
        if (path == null || path.length() > range || path.isEmpty()) {
            return null;
        }
        char firstChar = path.charAt(0);
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != firstChar) {
                return null;
            }
        }
        return String.valueOf(firstChar);
    }

    private static boolean canAttackByGun(String path, Hero hero) {
        if (!isHaveGun(hero)) return false;
        return checkString(path, hero.getInventory().getGun().getRange()) != null;
    }

    private static boolean canAttackByMelee(String path, Hero hero) {
        if (!isHaveMelee(hero)) return false;
        return checkString(path, hero.getInventory().getMelee().getRange()) != null;
    }

    private static boolean isHaveGun(Hero hero) {
        return hero.getInventory().getGun() != null;
    }

    private static boolean isHaveMelee(Hero hero) {
        return hero.getInventory().getMelee() != null &&
                !hero.getInventory().getMelee().getId().equalsIgnoreCase("HAND");
    }
}