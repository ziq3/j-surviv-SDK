/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.socket;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Inventory;
import jsclub.codefest2024.sdk.socket.event_handler.onTestGameReceive;
import jsclub.codefest2024.sdk.util.SocketUtil;

/**
 * SocketClient for connecting to a server using Socket.IO.
 * Author: AD
 */
public class SocketClient {
    private final String defaultUrl = "http://localhost:3000/sdk";
    private Socket socket;
    private final Inventory heroInventory;

    /**
     * Connects to the server at the specified URL.
     *
     * @param serverUrl The URL of the server to connect to.
     * @return true if connection was initiated successfully, false otherwise.
     */
    public Boolean connectToServer(String serverUrl, Emitter.Listener onMapUpdate) {
        if (socket != null) {
            socket.disconnect();
            socket = null;
        }

        socket = SocketUtil.init(serverUrl);

        if (socket == null) {
            return false;
        }

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("Connected to the server");
                socket.on(EventName.ON_TEST_GAME_RECEIVE, new onTestGameReceive(socket));
                socket.on(EventName.ON_MAP_UPDATE, onMapUpdate);
            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("Disconnected from the server");
            }
        });

        socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.err.println("Connection error: " + args[0]);
            }
        });

        socket.connect();
        return true;
    }

    /**
     * Disconnects from the currently connected server.
     */
    public void disconnectFromServer() {
        if (socket != null && socket.connected()) {
            socket.disconnect();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public SocketClient(Inventory heroInventory) {
        this.heroInventory = heroInventory;
    }
}
