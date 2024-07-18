/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;

/**
 *
 * @author Son Duong
 */
public class Hero {
    private static final Logger LOGGER = LogManager.getLogger(Hero.class);
    private String player_name = "";
    private String gameID = "";
    private Socket socket;
    
    public Hero(String player_name, String gameID) {
        this.player_name = player_name;
        this.gameID = gameID;
    }
    
    public String getPlayerID() {
        return player_name;
    }

    public String getGameID() {
        return gameID;
    }
    
    
    public void move(String step) {
        if (socket != null && step.length() > 0) {
            Dir dir = new Dir(step);
            LOGGER.debug("Player = {} - Dir = {}", this.player_name, dir);
            try {
                socket.emit("driver player", new JSONObject(dir.toString()));
            } catch (JSONException e) {
                LOGGER.error(e);
            }
        }
    }

}
