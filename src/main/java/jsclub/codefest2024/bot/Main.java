package jsclub.codefest2024.bot;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.Hero;

import java.io.IOException;

public class Main {
    private static final String SERVER_URL = "https://cf-server.jsclub.dev";
    private static final String GAME_ID = "123704";
    private static final String PLAYER_NAME = "player1";

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

                    hero.move(randomMove());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }
}
