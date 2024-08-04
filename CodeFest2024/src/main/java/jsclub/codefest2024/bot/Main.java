package jsclub.codefest2024.bot;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.Hero;

import java.io.IOException;

public class Main {
    private static final String SERVER_URL = "https://cf-server.jsclub.dev";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero("player1", "game1");

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                GameMap gameMap = hero.getGameMap();

                // Update game map
//                gameMap.updateOnUpdateMap(args[0]);

                // Perform actions based on game map
                System.out.println(gameMap);
            }
        };

        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }
}
