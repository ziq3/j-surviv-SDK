/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.model;

/**
 *
 * @author Son Duong
 */
public class Inventory {
    private String player_name;
    private String action;
    private int item_id;

    public Inventory() {
    }

    public Inventory(String player_name, String action, int item_id) {
        this.player_name = player_name;
        this.action = action;
        this.item_id = item_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
    
}
