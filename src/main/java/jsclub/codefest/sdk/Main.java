package jsclub.codefest.sdk;

import com.google.gson.Gson;
import io.socket.emitter.Emitter;
import jsclub.codefest.sdk.algorithm.PathUtils;
import jsclub.codefest.sdk.base.Node;
import jsclub.codefest.sdk.model.GameMap;
import jsclub.codefest.sdk.model.players.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SERVER_URL = "https://cf25-server-staging.jsclub.dev";
    //    private static final String SERVER_URL = "http://192.168.123.126:3000";
    private static final String GAME_ID = "185440";
    private static final String PLAYER_NAME = "phi";
    private static final String SECRET_KEY = "sk-7YLsiWMySB-d_CgInug_mw:kdeAyOViSRxixQCj4VgYfiT1TJpg5AVbUgrcNonekN0ib9zSHrDTO-L3nKc9GKA40rlFjBT10C_dftiVuMaj1Q";
//    private static final String SECRET_KEY = "sk-bKmGDraDRVSV1opmx1gZ7Q:YYrurLaSNj8-FVHpMiYtfWn5quvLda1NevFOe6d41QL3JCKDl8WVy5xsi34fXdjWS3SRQIdGtCNBD8Hk-gkWHw";

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero(GAME_ID, PLAYER_NAME,SECRET_KEY);
        Emitter.Listener onMapUpdate = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                GameMap gameMap = hero.getGameMap(); // map
                gameMap.updateOnUpdateMap(args[0]);
                    try{
                        Player currenPlayer = gameMap.getCurrentPlayer();
                        if (currenPlayer != null) {
                            System.out.println("Current posotion:" + printPosition(currenPlayer));
                        }
                        List<Node> restrctedNode = new ArrayList<>();
                        String path = PathUtils.getShortestPath(gameMap, restrctedNode, currenPlayer, new Node(20, 20), true);
                        hero.move(path);
                    } catch (IOException ex){
                        String errMsg = new Gson().toJson((Object) ex);
                        System.err.println("Error"+errMsg);
                    }
            }
        };
        hero.setOnMapUpdate(onMapUpdate);
        hero.start(SERVER_URL);
    }

    private static String printPosition(Node node) {
        return "(" + node.x + "," + node.y + ")";
    }

    private static Node getPosition(Node node) {
        return node;
    }
}


