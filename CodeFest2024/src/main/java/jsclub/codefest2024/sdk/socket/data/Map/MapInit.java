/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.socket.data.Map;

import java.util.Map;
import jsclub.codefest2024.socket.data.Enemies.*;
import jsclub.codefest2024.socket.data.Equipments.*;
import jsclub.codefest2024.socket.data.Obstacles.Obstacle;
import jsclub.codefest2024.socket.data.Weapon.*;
import jsclub.codefest2024.util.*;

/**
 *
 * @author AD
 */
public class MapInit {
    private int mapHeight;
    private int mapWidth;
    private int darkAreaWidth;
    final private ArmorUtil armorList;
    final private ChaserUtil chaserList;
    final private HealingItemUtil HealItemList;
    final private ObstacleUtil ObstacleList;
    final private WeaponUtil weaponList;

    public MapInit() {
        this.mapHeight=0;
        this.mapWidth=0;
        this.darkAreaWidth=0;
        this.armorList = new ArmorUtil();
        this.chaserList = new ChaserUtil();
        this.HealItemList = new HealingItemUtil();
        this.ObstacleList = new ObstacleUtil();
        this.weaponList = new WeaponUtil();
    }
    public MapInit(int mapHeight, int mapWidth, int darkAreaWidth) {
        this.mapHeight=mapHeight;
        this.mapWidth=mapWidth;
        this.darkAreaWidth=darkAreaWidth;
        this.armorList = new ArmorUtil();
        this.chaserList = new ChaserUtil();
        this.HealItemList = new HealingItemUtil();
        this.ObstacleList = new ObstacleUtil();
        this.weaponList = new WeaponUtil();
    }

    public void updateMap(){
        
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
            case "armor" -> {
                for (Map.Entry<String, Armor> e : armorList.armorList.entrySet()) {
                    System.out.println(e.getKey() + ": " + e.getValue());
                }
            }
            case "heal_item" -> {
                for (Map.Entry<String, HealingItem> e : HealItemList.healingItemList.entrySet()) {
                    System.out.println(e.getKey() + ": " + e.getValue());
                }
            }
            case "weapon" -> {
                for (Map.Entry<String, Weapon> e : weaponList.weaponList.entrySet()) {
                    System.out.println(e.getKey() + ": " + e.getValue());
                }
            }
            default -> System.out.println("Invalid type");
        }
    }
    
    public void getAllEnemies(){
        for (Map.Entry<String, Chaser> e : chaserList.chaserList.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
    
    public void getAllDestructible(){
        for (Map.Entry<String, Obstacle> e : ObstacleList.obstacleList.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
    
    public static void main(String[] args) {
        MapInit m = new MapInit();
        System.out.println("List weapons:");
        m.getElementByType("weapon");
        System.out.println("Find weapon:");
        String name = "Ball";
        System.out.println(name.toUpperCase()+":"+ m.weaponList.getWeapon(name.toUpperCase()));

    }
}
