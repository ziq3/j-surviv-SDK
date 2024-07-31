/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Son Duong
 */
public class InventoryUpdateData {

    @SerializedName("player_name")
    public String playerName ;

    public String action;

    @SerializedName("item_id")
    public Items item;

    public InventoryUpdateData() {
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
