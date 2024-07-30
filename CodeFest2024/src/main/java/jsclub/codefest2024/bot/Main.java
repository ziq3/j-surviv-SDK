package jsclub.codefest2024.bot;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;

public class Main {
    private static Socket socket;

    public static void main(String[] args) {
        try {
            // Connect to the server with the specified namespace
            socket = IO.socket("https://cf-server.jsclub.dev/health");

            // Set up event listeners
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Connected to server");
                }
            }).on("event_name", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    // Handle the event
                    System.out.println("Event received: " + args[0]);
                }
            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Disconnected from server");
                }
            });

            // Connect the socket
            socket.connect();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
