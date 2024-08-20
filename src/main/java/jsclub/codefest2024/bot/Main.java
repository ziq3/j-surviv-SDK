package jsclub.codefest2024.bot;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.algorithm.ShortestPath;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.Hero;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String SERVER_URL = "https://cf-server.jsclub.dev";
    private static final String GAME_ID = "167596";
    private static final String PLAYER_NAME = "player1";

    static String p = "urrl";

    private static long lastCallTime = 0;  // External variable to track time across calls

    public static String randomMove() {
        String[] moves = {"u", "d", "l", "r"};
        return moves[(int) (Math.random() * moves.length)];
    }

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                long currentTime = System.currentTimeMillis();
                if (lastCallTime != 0) {
                    long timeDifference = currentTime - lastCallTime;
                    System.out.println("Time between calls: " + timeDifference + " ms");
                }
                lastCallTime = currentTime;  // Update the last call time

                try {
                    GameMap gameMap = hero.getGameMap();
                    gameMap.updateOnUpdateMap(args[0]);

                    Weapon melee = hero.getInventory().getMelee();
                    Weapon gun = hero.getInventory().getGun();

                    System.out.println("Melee:" + melee);
                    System.out.println("Gun:" + gun);
//                    if(melee != null){
//                        hero.revokeItem(melee.getId());
//                    }
//                    if(gun != null){
//                        hero.revokeItem(gun.getId());
//                    }

                    List<Weapon> weapon = gameMap.getListWeapons();
                    for(Weapon w : weapon) {
                        if(w.getX() == gameMap.getCurrentPlayer().x && w.getY() == gameMap.getCurrentPlayer().y) {
                            System.out.println("LỤM");
                            hero.pickupItem();

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
}
