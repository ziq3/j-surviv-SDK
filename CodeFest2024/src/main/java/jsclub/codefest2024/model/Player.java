/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.model;

import com.google.gson.Gson;

/**
 *
 * @author Son Duong
 */
public class Player {

    public String player_name;
    public int hp;
    public int x;
    public int y;
    public String effect;
    public int effect_time_left;
    public int bullet_num;
    public int point;
    
    
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
