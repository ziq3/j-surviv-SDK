package jsclub.codefest.sdk;

import io.socket.emitter.Emitter;
import jsclub.codefest.sdk.algorithm.PathUtils;
import jsclub.codefest.sdk.base.Node;
import jsclub.codefest.sdk.model.GameMap;
import jsclub.codefest.sdk.model.players.Player;

import java.io.IOException;

public class Main {
    private static final String SERVER_URL = "https://cf25-server-staging.jsclub.dev";
    //    private static final String SERVER_URL = "http://192.168.123.126:3000";
    private static final String GAME_ID = "DEMO133";
    private static final String PLAYER_NAME = "phi";
    private static final String SECRET_KEY = "sk-hVA_5XJ9Tj-3tqbqH-QHcw:mwGy6DygTBsxAWvoJzWiCMkTz5hAu4RSYWV5fTSyADrfNl_Nw6TE1mWPb8a0msX2FS5G7b-gFAXjLfG2Duy60w";
//    private static final String SECRET_KEY = "sk-bKmGDraDRVSV1opmx1gZ7Q:YYrurLaSNj8-FVHpMiYtfWn5quvLda1NevFOe6d41QL3JCKDl8WVy5xsi34fXdjWS3SRQIdGtCNBD8Hk-gkWHw";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME,SECRET_KEY);
        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("Start a try");
                GameMap gameMap = hero.getGameMap(); // map
                Player currenPlayer = gameMap.getCurrentPlayer();
                gameMap.updateOnUpdateMap(args[0]);
                    try{
//                        String path = PathUtils.getShortestPath(gameMap,null,new Node(currenPlayer.getX(), currenPlayer.getY()),new Node(20,20),true);
                        hero.move("u");
                    } catch (IOException ex){
                        System.err.println("Error"+ex);
                    }
                System.out.println(gameMap);
            }
        };
        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }
}
