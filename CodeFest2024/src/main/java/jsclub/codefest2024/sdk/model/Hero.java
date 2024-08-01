/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import io.socket.client.Socket;
import jsclub.codefest2024.sdk.socket.EventName;
import jsclub.codefest2024.sdk.socket.SocketClient;
import jsclub.codefest2024.sdk.socket.data.emit_data.*;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

import java.io.IOException;

public class Hero {
    private String playerName = "";
    private String gameID = "";
    private final SocketClient socketClient;
    private final GameMap gameMap;
    
    public Hero(String playerName, String gameID) {
        this.playerName = playerName;
        this.gameID = gameID;

        this.gameMap = new GameMap();
        this.socketClient = new SocketClient();
    }

    public void start(String serverURL) {
        socketClient.connectToServer(serverURL + "/sdk");
    }


    public String getPlayerID() {
        return playerName;
    }
    public String getGameID() {
        return gameID;
    }

    public void move(String move) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            BotMove botMove = new BotMove(move);

            byte[] bytes = MsgPackUtil.encodeFromObject(botMove);
            socket.emit(EventName.EMIT_MOVE, bytes);
        }
    }

    public void shoot() throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            String data = "{}";
            byte[] bytes = MsgPackUtil.encodeFromObject(data);
            socket.emit(EventName.EMIT_SHOOT, bytes);
        }
    }

    public void attack() throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            String data = "{}";
            byte[] bytes = MsgPackUtil.encodeFromObject(data);
            socket.emit(EventName.EMIT_ATTACK, bytes);
        }
    }

    public void throwItem(int itemId, int destinationX, int destinationY) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            BotThrow botThrow = new BotThrow(itemId, destinationX, destinationY);

            byte[] bytes = MsgPackUtil.encodeFromObject(botThrow);
            socket.emit(EventName.EMIT_THROW, bytes);
        }
    }

    public void pickupItem() throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            String data = "{}";
            byte[] bytes = MsgPackUtil.encodeFromObject(data);
            socket.emit(EventName.EMIT_PICKUP_ITEM, bytes);
        }
    }

    public void useItem(int itemId) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            BotUseItem botUseItem = new BotUseItem(itemId);

            byte[] bytes = MsgPackUtil.encodeFromObject(botUseItem);
            socket.emit(EventName.EMIT_USE_ITEM, bytes);
        }
    }

    public void revokeItem(int itemId) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            BotRevokeItem botRevokeItem = new BotRevokeItem(itemId);

            byte[] bytes = MsgPackUtil.encodeFromObject(botRevokeItem);
            socket.emit(EventName.EMIT_REVOKE_ITEM, bytes);
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public GameMap getGameMap() {
        return gameMap;
    }
}
