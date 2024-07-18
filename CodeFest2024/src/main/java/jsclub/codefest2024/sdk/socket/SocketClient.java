/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.socket;

import io.socket.client.Socket;
import jsclub.codefest2024.sdk.util.SocketUtil;

/**
 * SocketClient for connecting to a server using Socket.IO.
 * Author: AD
 */
public class SocketClient {
    final private String defaultUrl = "http://localhost:3000";
    private Socket socket;

    /**
     * Connects to the server at the specified URL.
     * 
     * @param serverUrl The URL of the server to connect to.
     * @return true if connection was initiated successfully, false otherwise.
     */
    public Boolean connectToServer(String serverUrl) {
        if (socket != null) {
            socket.disconnect();
            socket = null;
        }

        socket = SocketUtil.init(serverUrl);

        if (socket == null) {
            return false;
        }

        socket.on(Socket.EVENT_CONNECT, objects -> {
            try {
                System.out.println("Connected to the server");
                socket.on("message", (Object... args) -> {
                    System.out.println("Message from server: " + args[0]);
                });

            socket.emit("message", "From client: ","Hello server" );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        socket.on(Socket.EVENT_DISCONNECT, objects -> {
            System.out.println("Disconnected from the server");
        });

        socket.on(Socket.EVENT_CONNECT_ERROR, objects -> {
            System.err.println("Connection error: " + objects[0]);
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
    
    public static void main(String[] args) {
        SocketClient cli = new SocketClient();
        cli.connectToServer(cli.defaultUrl);
    }
}
