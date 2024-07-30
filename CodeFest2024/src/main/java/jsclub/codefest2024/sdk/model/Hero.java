/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import jsclub.codefest2024.sdk.socket.SocketClient;

import java.util.Map;

/**
 *
 * @author Son Duong
 */
public class Hero {
    private String player_name = "";
    private String gameID = "";
    private final SocketClient socketClient;
    
    public Hero(String player_name, String gameID) {
        this.player_name = player_name;
        this.gameID = gameID;

        this.socketClient = new SocketClient();
    }

    public void start(String serverURL) {
        socketClient.connectToServer(serverURL + "/sdk");
    }
    
    public String getPlayerID() {
        return player_name;
    }
    public String getGameID() {
        return gameID;
    }

}
