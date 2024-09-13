package jsclub.codefest2024.sdk;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.GameMap;
import jsclub.codefest2024.sdk.model.Inventory;
import jsclub.codefest2024.sdk.socket.EventName;
import jsclub.codefest2024.sdk.socket.SocketClient;
import jsclub.codefest2024.sdk.socket.data.emit_data.*;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

import java.io.IOException;

public class Hero {
    private String playerName = "";
    private String playerKey = "";
    private String gameID = "";
    private final SocketClient socketClient;
    private final GameMap gameMap;
    private final Inventory inventory;
    private Emitter.Listener onMapUpdate;

    public Hero(String gameID, String playerName, String playerKey) {
        this.playerName = playerName;
        this.playerKey = playerKey;
        this.gameID = gameID;
        this.inventory = new Inventory();
        this.gameMap = new GameMap(this.getInventory());
        this.socketClient = new SocketClient(this.inventory, this.gameMap);
    }

    public void start(String serverURL) throws IOException {
        if (this.onMapUpdate == null) {
            throw new RuntimeException("onMapUpdate is not set");
        }

        if (this.playerName.isEmpty()) {
            throw new RuntimeException("playerName is not set");
        }

        if (this.playerKey.isEmpty()) {
            throw new RuntimeException("playerKey is not set");
        }

        if (this.gameID.isEmpty()) {
            throw new RuntimeException("gameID is not set");
        }

        socketClient.connectToServer(serverURL, this.playerName, this.playerKey, this.onMapUpdate);
        this.joinGame();
    }

    public String getPlayerID() {
        return playerName;
    }

    public String getGameID() {
        return gameID;
    }

    public void joinGame() throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerJoinGameAction joinGame = new PlayerJoinGameAction(this.gameID, this.playerName);

            byte[] bytes = MsgPackUtil.encodeFromObject(joinGame);
            socket.emit(EventName.EMIT_JOIN_GAME, (Object) bytes);
        }
    }

    /**
     * Moves the player in the specified direction ('l', 'r', 'u', 'd').
     *
     * @param direction the direction in which to move the player
     * @throws IOException if an I/O error occurs
     */
    public void move(String direction) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerMoveAction botMove = new PlayerMoveAction(direction);

            byte[] bytes = MsgPackUtil.encodeFromObject(botMove);
            socket.emit(EventName.EMIT_MOVE, (Object) bytes);
        }
    }

    /**
     * Shoots a projectile in the specified direction ('l', 'r', 'u', 'd').
     *
     * @param direction the direction in which to shoot
     * @throws IOException if an I/O error occurs
     */
    public void shoot(String direction) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerShootAction botShoot = new PlayerShootAction(direction);

            byte[] bytes = MsgPackUtil.encodeFromObject(botShoot);
            socket.emit(EventName.EMIT_SHOOT, (Object) bytes);
        }
    }

    /**
     * Performs a melee attack in the specified direction ('l', 'r', 'u', 'd').
     *
     * @param direction the direction in which to attack
     * @throws IOException if an I/O error occurs
     */
    public void attack(String direction) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerAttackAction botAttack = new PlayerAttackAction(direction);

            byte[] bytes = MsgPackUtil.encodeFromObject(botAttack);
            socket.emit(EventName.EMIT_ATTACK, (Object) bytes);
        }
    }

    /**
     * Throws a throwable object in the specified direction ('l', 'r', 'u', 'd').
     *
     * @param direction the direction in which to throw the object
     * @throws IOException if an I/O error occurs
     */
    public void throwItem(String direction) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerThrowItemAction botThrow = new PlayerThrowItemAction(direction);

            byte[] bytes = MsgPackUtil.encodeFromObject(botThrow);
            socket.emit(EventName.EMIT_THROW, (Object) bytes);
        }
    }

    /**
     * Picks up an item at the player's current position.
     *
     * @throws IOException if an I/O error occurs
     */
    public void pickupItem() throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            String data = "{}";
            byte[] bytes = MsgPackUtil.encodeFromObject(data);
            socket.emit(EventName.EMIT_PICKUP_ITEM, (Object) bytes);
        }
    }

    /**
     * Uses an item with the specified ID.
     *
     * @param itemId the ID of the item to use
     * @throws IOException if an I/O error occurs
     */
    public void useItem(String itemId) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerUseItemAction botUseItem = new PlayerUseItemAction(itemId);

            byte[] bytes = MsgPackUtil.encodeFromObject(botUseItem);
            socket.emit(EventName.EMIT_USE_ITEM, (Object) bytes);
        }
    }

    /**
     * Revokes an item with the specified ID.
     *
     * @param itemId the ID of the item to revoke
     * @throws IOException if an I/O error occurs
     */
    public void revokeItem(String itemId) throws IOException {
        Socket socket = socketClient.getSocket();

        if (socket != null) {
            PlayerRevokeItemAction botRevokeItem = new PlayerRevokeItemAction(itemId);

            byte[] bytes = MsgPackUtil.encodeFromObject(botRevokeItem);
            socket.emit(EventName.EMIT_REVOKE_ITEM, (Object) bytes);
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    /**
     * Retrieves the current game map information.
     *
     * @return the current game map
     */
    public GameMap getGameMap() {
        return gameMap;
    }

    public void setOnMapUpdate(Emitter.Listener onMapUpdate) {
        this.onMapUpdate = onMapUpdate;
    }

    /**
     * Retrieves the player's inventory information.
     *
     * @return the player's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
