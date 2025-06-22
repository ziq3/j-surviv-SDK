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
import java.util.Random;

public class Main {
    private static final String SERVER_URL = "https://cf25-server-staging.jsclub.dev";
    private static final String GAME_ID = "195646";
    private static final String PLAYER_NAME = "phi";
    private static final String SECRET_KEY = "sk-3DnoWZ2NTR-t5DuKDbDLPw:sbmN2FvyAGU0YwIC95vQdZXjMMYhuoM0i2vBsqsnbGyPazpGvAsC9HCQWkScSNyvAX1Rr91NOjGL-7KAa3XsEw";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME, SECRET_KEY);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            private int stuckCounter = 0;
            private Node lastPosition = new Node(-1, -1); // Vị trí ở lần chạy trước
            private static final int STUCK_LIMIT = 4; // Ngưỡng nhận diện bị kẹt

            @Override
            public void call(Object... args) {
                try {
                    // --- BƯỚC 0: KIỂM TRA AN TOÀN VÀ CẬP NHẬT TRẠNG THÁI ---
                    if (args == null || args.length == 0) return;

                    GameMap gameMap = hero.getGameMap();
                    gameMap.updateOnUpdateMap(args[0]);
                    System.out.println("game map update:"+gameMap);
                    Player player = gameMap.getCurrentPlayer();

                    if (player == null || player.getHealth() ==0) {
                        System.out.println("Nhân vật đã chết hoặc chưa có dữ liệu.");
                        return;
                    }

                    // --- BƯỚC 1: XỬ LÝ CHỐNG KẸT (ANTI-STUCK) ---
                    if (isStuck(player)) {
                        stuckCounter++;
                        System.out.println("Phát hiện có dấu hiệu bị kẹt: " + stuckCounter + "/" + STUCK_LIMIT);
                    } else {
                        stuckCounter = 0; // Reset bộ đếm nếu có di chuyển
                    }
                    updateLastPosition(player);

                    if (stuckCounter > STUCK_LIMIT) {
                        System.out.println("Bị kẹt! Thử di chuyển ngẫu nhiên để thoát.");
                        hero.move(getRandomDirection());
                        stuckCounter = 0; // Reset sau khi đã xử lý
                        return;
                    }

                    // --- BƯỚC 2: XÂY DỰNG CÂY QUYẾT ĐỊNH THÔNG MINH ---
                    List<Node> nodesToAvoid = getNodeNeedToAvoid(gameMap);

                    // LUỒNG 1: ƯU TIÊN HÀNG ĐẦU - KIẾM SÚNG NẾU CHƯA CÓ HOẶC HẾT ĐẠN
                    if (!isHaveGun(hero) || isOutOfAmmo(hero)) {
                        if (isOutOfAmmo(hero)) System.out.println("Hết đạn! Tìm súng mới.");
                        else System.out.println("Chưa có súng. Đi tìm súng.");

                        String pathToGun = findPathToGun(gameMap, nodesToAvoid, player);
                        if (pathToGun != null) {
                            if (pathToGun.isEmpty()) {
                                hero.pickupItem();
                            } else {
                                hero.move(pathToGun);
                            }
                        } else {
                            // Không tìm thấy súng, tạm thời đi tấn công bằng vũ khí cận chiến
                            System.out.println("Không có súng trên bản đồ, chuyển sang cận chiến.");
                            handleMeleeAttack(hero, gameMap, nodesToAvoid, player);
                        }
                        return;
                    }

                    // LUỒNG 2: KHI ĐÃ CÓ SÚNG VÀ ĐẠN - ĐI SĂN NGƯỜI
                    if (isHaveGun(hero) && !isOutOfAmmo(hero)) {
                        String pathToEnemy = findPathToOtherPlayer(gameMap, nodesToAvoid, player);

                        if (pathToEnemy != null) {
                            // Kiểm tra điều kiện tấn công đặc biệt: path là 3 ký tự giống nhau
                            if (isSpecialAttackPath(pathToEnemy)) {
                                System.out.println("Mục tiêu ở vị trí đẹp! Bắn theo đường: " + pathToEnemy);
                                hero.shoot(pathToEnemy.substring(0, 1)); // Bắn theo hướng của path
                            }
                            // Nếu không thì kiểm tra tầm bắn thông thường
                            else if (canAttackByGun(pathToEnemy, hero)) {
                                System.out.println("Mục tiêu trong tầm bắn. Bắn!");
                                hero.shoot(checkString(pathToEnemy, hero.getInventory().getGun().getRange()));
                            }
                            // Nếu không tấn công được, di chuyển lại gần
                            else {
                                System.out.println("Di chuyển đến gần kẻ địch hơn: " + pathToEnemy);
                                hero.move(pathToEnemy);
                            }
                        } else {
                            System.out.println("Không tìm thấy kẻ địch, di chuyển ngẫu nhiên.");
                            hero.move(getRandomDirection());
                        }
                    }

                } catch (Exception e) {
                    System.err.println("Lỗi nghiêm trọng trong hàm call: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // --- CÁC HÀM HỖ TRỢ CHO VIỆC CHỐNG KẸT ---
            private boolean isStuck(Player player) {
                return player.x == lastPosition.x && player.y == lastPosition.y;
            }

            private void updateLastPosition(Player player) {
                lastPosition.setPosition(player.x, player.y);
            }

        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }

    // ============================================================================================
    // CÁC HÀM HỖ TRỢ (HELPER FUNCTIONS)
    // ============================================================================================

    private static void handleMeleeAttack(Hero hero, GameMap gameMap, List<Node> nodes, Player player) throws IOException {
        String pathToEnemy = findPathToOtherPlayer(gameMap, nodes, player);
        if (pathToEnemy != null) {
            if (isHaveMelee(hero) && canAttackByMelee(pathToEnemy, hero)) {
                hero.attack(checkString(pathToEnemy, hero.getInventory().getMelee().getRange()));
            } else {
                hero.move(pathToEnemy);
            }
        } else {
            hero.move(getRandomDirection());
        }
    }

    private static String getRandomDirection() {
        String[] directions = {"u", "d", "l", "r"};
        return directions[new Random().nextInt(directions.length)];
    }

    private static boolean isOutOfAmmo(Hero hero) {
        return isHaveGun(hero);
    }

    private static boolean isSpecialAttackPath(String path) {
        if (path == null || path.length() != 3) {
            return false;
        }
        // Kiểm tra xem 3 ký tự có giống nhau không
        return path.charAt(0) == path.charAt(1) && path.charAt(1) == path.charAt(2);
    }

    // ... (Các hàm helper cũ giữ nguyên và được cải tiến) ...

    private static List<Node> getNodeNeedToAvoid(GameMap gameMap) {
        List<Node> nodes = new ArrayList<>();
        for (Obstacle obstacle : gameMap.getListIndestructibleObstacles()) {
            nodes.add(obstacle);
        }
        for (Player player : gameMap.getOtherPlayerInfo()) {
            nodes.add(player);
        }
        // Thêm các vật cản có thể phá hủy vào danh sách cần tránh
        for(Obstacle obstacle : gameMap.getListObstacles()){
            nodes.add(obstacle);
        }
        return nodes;
    }

    private static String findPathToOtherPlayer(GameMap gameMap, List<Node> nodes, Player player) {
        Player nearestPlayer = getNearestPlayer(gameMap, player);
        if (nearestPlayer == null) return null;
        List<Node> tempNodes = new ArrayList<>(nodes);
        tempNodes.remove(nearestPlayer);
        return PathUtils.getShortestPath(gameMap, tempNodes, player, nearestPlayer, false);
    }

    private static String findPathToGun(GameMap gameMap, List<Node> nodes, Player player) {
        System.out.println("path to gun: "+gameMap.getAllGun().isEmpty());
        if (gameMap.getAllGun().isEmpty()) return null;
        Weapon nearestGun = getNearestGun(gameMap, player);
        if(nearestGun == null) return null;
        return PathUtils.getShortestPath(gameMap, nodes, player, nearestGun, false);
    }

    private static Player getNearestPlayer(GameMap gameMap, Player player) {
        List<Player> otherPlayers = gameMap.getOtherPlayerInfo();
        Player target = null;
        double minDistance = Double.MAX_VALUE;
        for (Player otherPlayer : otherPlayers) {
            if (otherPlayer.getHealth() ==0) { // Chỉ tìm người chơi còn sống
                double distance = Math.pow(player.x - otherPlayer.x, 2) + Math.pow(player.y - otherPlayer.y, 2);
                if (distance < minDistance) {
                    minDistance = distance;
                    target = otherPlayer;
                }
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