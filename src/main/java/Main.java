import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.Hero;
import jsclub.codefest2024.sdk.model.GameMap;

import java.io.IOException;

public class Main {
    private static final String SERVER_URL = "https://cf25-server-staging.jsclub.dev";
//    private static final String SERVER_URL = "http://192.168.123.126:3000";
    private static final String GAME_ID = "159910";
    private static final String PLAYER_NAME = "phi";
    private static final String PLAYER_KEY = "159910";
    private static final String SECRET_KEY = "sk-zsSlPQT_R_-vRYEi0FYVhA:rQ2O70MyHthadd-rcUryK3i4rtsWp2pG1UHrWktTNz6vhBJC8fnzpJZ-wfHKk8aTJYb8nhcY97DmwsC2NZDXZA";
//    private static final String SECRET_KEY = "sk-bKmGDraDRVSV1opmx1gZ7Q:YYrurLaSNj8-FVHpMiYtfWn5quvLda1NevFOe6d41QL3JCKDl8WVy5xsi34fXdjWS3SRQIdGtCNBD8Hk-gkWHw";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME,PLAYER_KEY,SECRET_KEY);

        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("Start a try");
                GameMap gameMap = hero.getGameMap(); // map
                gameMap.updateOnUpdateMap(args[0]);
            }
        };
        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }
}