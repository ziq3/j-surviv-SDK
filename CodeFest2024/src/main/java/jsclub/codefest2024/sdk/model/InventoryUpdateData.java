/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Son Duong
 */
public class InventoryUpdateData {

    public String player_name;
    public String action;
    public Items item;

    public InventoryUpdateData() {
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
