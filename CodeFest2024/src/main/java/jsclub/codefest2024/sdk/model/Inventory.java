/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 *
 * @author Son Duong
 */
public class Inventory {

    public String player_name;
    public Items item;

    public Inventory() {
    }

    public Map<Items, Integer> INVENTORY = new HashMap<>() {
        {
            put(Items.WATER_GUN, 0);
            put(Items.LEGO_GUN, 0);
            put(Items.RUBBER_GUN, 0);
            put(Items.BADMINTON, 0);
            put(Items.BROOM, 0);
            put(Items.SANDAL, 0);
            put(Items.LIGHT_SABER, 0);
            put(Items.HAND, 0);
            put(Items.PAPER_AIRPLANE, 0);
            put(Items.BALL, 0);
            put(Items.PAPER_DART, 0);
            put(Items.TEDDY_BEAR, 0);
            put(Items.WATER_BALL, 0);
            put(Items.SNACK, 0);
            put(Items.INSECTICIDE, 0);
            put(Items.DRINK, 0);
            put(Items.BANDAGES, 0);
            put(Items.LUNCH_BOX, 0);
            put(Items.VEST, 0);
            put(Items.POT, 0);
            put(Items.HELMET, 0);
        }
    };


    public Map<Items, Integer> getInventory() {
        return INVENTORY;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
