/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.model;

import io.socket.client.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Son Duong
 */
public class Player {

    private static final Logger LOGGER = LogManager.getLogger(Player.class);
    private String player_name;
    private int hp;
    private int x;
    private int y;
    private String effect;
    private int effect_time_left;
    private int bullet_num;
    private int point;
    private Socket socket;

    public Player() {
    }

    public Player(String player_name, int hp, int x, int y, String effect, int effect_time_left, int bullet_num, int point) {
        this.player_name = player_name;
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.effect = effect;
        this.effect_time_left = effect_time_left;
        this.bullet_num = bullet_num;
        this.point = point;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getEffect_time_left() {
        return effect_time_left;
    }

    public void setEffect_time_left(int effect_time_left) {
        this.effect_time_left = effect_time_left;
    }

    public int getBullet_num() {
        return bullet_num;
    }

    public void setBullet_num(int bullet_num) {
        this.bullet_num = bullet_num;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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
