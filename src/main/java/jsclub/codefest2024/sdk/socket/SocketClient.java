package jsclub.codefest2024.sdk.socket;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.model.Inventory;
import jsclub.codefest2024.sdk.socket.event_handler.onMapInit;
import jsclub.codefest2024.sdk.socket.event_handler.onPlayerInventoryAdd;
import jsclub.codefest2024.sdk.socket.event_handler.onPlayerInventoryUpdate;
import jsclub.codefest2024.sdk.socket.event_handler.onplayerInventoryClear;
import jsclub.codefest2024.sdk.util.SocketUtil;

import java.util.concurrent.CompletableFuture;

public class SocketClient {
    private Socket socket;
    private final Inventory heroInventory;
    private final GameMap gameMap;

    public CompletableFuture<Void> connectToServer(String serverUrl, String playerName, String secretKey, Emitter.Listener onMapUpdate) {
        CompletableFuture<Void> connectionFuture = new CompletableFuture<>();

        if (socket != null) {
            socket.disconnect();
            socket = null;
        }

        socket = SocketUtil.init(serverUrl + "/bot/socket?secretKey=" + secretKey, playerName);
        if (socket == null) {
            connectionFuture.completeExceptionally(new IllegalStateException("Socket init failed"));
            return connectionFuture;
        }

        socket.on(Socket.EVENT_CONNECT, args -> {
            System.out.println("Connected to the server");

            socket.on(EventName.ON_MAP_INIT, new onMapInit(gameMap));
//            socket.on(EventName.ON_INVENTORY_UPDATE, new onPlayerInventoryUpdate(heroInventory));
            socket.on(EventName.ON_MAP_UPDATE, onMapUpdate);
            socket.on(EventName.ON_EFFECT_APPLY,new onPlayerInventoryAdd(heroInventory));
            socket.on(EventName.ON_EFFECT_CLEAR,new onplayerInventoryClear(heroInventory));
            socket.on(EventName.ON_PLAYER_REMOVE, args1 -> {
                System.out.println("You've been kicked out of the server");
                System.exit(0);
            });

            connectionFuture.complete(null); // signal success
        });

        socket.on(Socket.EVENT_DISCONNECT, args -> {
            System.out.println("Disconnected from the server");
        });

        socket.on(Socket.EVENT_CONNECT_ERROR, args -> {
            System.err.println("Connection error: " + args[0]);
            connectionFuture.completeExceptionally(new RuntimeException("Connection error: " + args[0]));
        });

        socket.connect();

        return connectionFuture;
    }
//    public void connectToServer(String serverUrl, String playerName, String playerKey, String secretKey, Emitter.Listener onMapUpdate) {
//        if (socket != null) {
//            socket.disconnect();
//            socket = null;
//        }
//
//        socket = SocketUtil.init(serverUrl + "/bot/socket?secretKey="+secretKey, playerName, playerKey);
//        if (socket == null) {
//            return;
//        }
//
//        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                System.out.println("Connected to the server");
//                socket.on(EventName.ON_MAP_INIT, new onMapInit(gameMap));
//                socket.on(EventName.ON_INVENTORY_UPDATE, new onPlayerInventoryUpdate(heroInventory));
//
//                socket.on(EventName.ON_MAP_UPDATE, onMapUpdate);
//
//                socket.on(EventName.ON_PLAYER_REMOVE, new Emitter.Listener() {
//                    @Override
//                    public void call(Object... args) {
//                        System.out.println("You've been kicked out of the server");
//                        System.exit(0);
//                    }
//                });
//            }
//        });
//
//        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                System.out.println("Disconnected from the server");
//            }
//        });
//
//        socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                System.err.println("Connection error: " + args[0]);
//                System.exit(1);
//            }
//        });
//
//        socket.connect();
//    }

    public Socket getSocket() {
        return socket;
    }

    public SocketClient(Inventory heroInventory, GameMap gameMap) {
        this.heroInventory = heroInventory;
        this.gameMap = gameMap;
    }
}
