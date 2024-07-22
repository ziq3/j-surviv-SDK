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
public class Dir {
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    public static final String UP = "u";
    public static final String DOWN = "d";
    
    public static final Map<String, String> MOVE_TO_STRING = new HashMap<String, String>() {
        {
            put(LEFT, "LEFT");
            put(RIGHT, "RIGHT");
            put(UP, "UP");
            put(DOWN, "DOWN");
        }
    };
    
    public final String direction;

    public Dir(String dir) {
        this.direction = dir;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
