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

    @SerializedName("type")
    public ElementType itemType;

    @SerializedName("id")
    public String id;

    @SerializedName("action")
    public String action;

    public InventoryUpdateData() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ElementType getItemType() {
        return itemType;
    }

    public void setItemType(ElementType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
