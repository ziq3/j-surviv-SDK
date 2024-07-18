/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.model;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Son Duong
 */
public class Inventory {

    enum Items {
        WATER_GUN,
        LEGO_GUN,
        RUBBER_GUN,
        BADMINTON,
        BROOM,
        SANDAL,
        LIGHT_SABER,
        HAND,
        PAPER_AIRPLANE,
        BALL,
        PAPER_DART,
        TEDDY_BEAR,
        WATER_BALL,
        SNACK,
        INSECTICIDE,
        DRINK,
        BANDAGES,
        LUNCH_BOX
    }

    enum Action {
        ADD,
        REMOVE
    }

    public String player_name;

    public Inventory() {
    }

    public static Map<Items, Integer> INVENTORY = new HashMap<>() {
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
        }
    };

    public void removeItem(Items item) {
        INVENTORY.put(item, 0);
    }

    public void addItem(Items item) {
        INVENTORY.put(item, INVENTORY.get(item) + 1);
    }

    public void actionItem(Items item, Action action) {
        switch(action){
            case ADD:
                addItem(item);
                break;
            case REMOVE:
                removeItem(item);
                break;
        }
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
