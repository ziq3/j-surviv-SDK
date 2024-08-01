/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import java.util.ArrayList;
import java.util.List;

import jsclub.codefest2024.sdk.model.enemies.*;
import jsclub.codefest2024.sdk.model.equipments.*;
import jsclub.codefest2024.sdk.model.obstacles.*;
import jsclub.codefest2024.sdk.model.weapon.*;

public class GameMap {
    private int mapSize = 0;
    private int darkAreaSize = 0;
    private List<Obstacle> listIndestructibleObstacles = new ArrayList<>();
    private List<Enemy> listEnemies = new ArrayList<>();
    private List<Obstacle> listTraps = new ArrayList<>();
    private List<Obstacle> listChests = new ArrayList<>();
    private List<Weapon> listWeapons = new ArrayList<>();
    private List<HealingItem> listHealingItems = new ArrayList<>();
    private List<Armor> listArmors = new ArrayList<>();
    private List<Bullet> listBullets = new ArrayList<>();
    private List<Player> otherPlayerInfo = new ArrayList<>();

    public GameMap() {}

    public int getMapSize() {
        return mapSize;
    }

    public int getDarkAreaSize() {
        return darkAreaSize;
    }

    public List<Obstacle> getListIndestructibleObstacles() {
        return listIndestructibleObstacles;
    }

    public List<Enemy> getListEnemies() {
        return listEnemies;
    }

    public List<Obstacle> getListTraps() {
        return listTraps;
    }

    public List<Obstacle> getListChests() {
        return listChests;
    }

    public List<Weapon> getListWeapons() {
        return listWeapons;
    }

    public List<HealingItem> getListHealingItems() {
        return listHealingItems;
    }

    public List<Armor> getListArmors() {
        return listArmors;
    }

    public List<Bullet> getListBullets() {
        return listBullets;
    }

    public List<Player> getOtherPlayerInfo() {
        return otherPlayerInfo;
    }
}
