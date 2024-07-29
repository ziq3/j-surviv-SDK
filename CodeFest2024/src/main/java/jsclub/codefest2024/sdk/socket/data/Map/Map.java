/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.socket.data.Map;

import jsclub.codefest2024.util.*;

/**
 *
 * @author AD
 */
public class Map {
    private int mapHeight;
    private int mapWidth;
    private int darkAreaWidth;
    private ArmorUtil armorList;
    private ChaserUtil chaserList;
    private HealingItemUtil HealItemList;
    private ObstacleUtil ObstacleList;
    private WeaponUtil weaponList;

    public Map() {
        this.mapHeight=0;
        this.mapWidth=0;
        this.darkAreaWidth=0;
        this.armorList = new ArmorUtil();
        this.chaserList = new ChaserUtil();
        this.HealItemList = new HealingItemUtil();
        this.ObstacleList = new ObstacleUtil();
        this.weaponList = new WeaponUtil();
    }
    enum Type {
        AMOR, ENEMY, HEALING_ITEM, OBSTACLE, WEAPON
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getDarkAreaWidth() {
        return darkAreaWidth;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setDarkAreaWidth(int darkAreaWidth) {
        this.darkAreaWidth = darkAreaWidth;
    }
    
    
    
    public void getElementByType(String type){
        //tra ve Element theo search type bao gom so luong cua element do va cac item thuoc kieu element do
        //vi du neu type la amor thi se tra ve so luong tung item thuoc kieu amor 
        switch(type.toLowerCase()){
            case "amor":
                
                break;
            default:
                System.out.println("Invalid type");
                break;
        }
    }
    
}
