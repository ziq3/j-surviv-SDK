/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.factory.*;
import jsclub.codefest2024.sdk.model.enemies.*;
import jsclub.codefest2024.sdk.model.equipments.*;
import jsclub.codefest2024.sdk.model.obstacles.*;
import jsclub.codefest2024.sdk.model.players.Player;
import jsclub.codefest2024.sdk.model.weapon.*;
import jsclub.codefest2024.sdk.socket.data.receive_data.MapData;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

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
    private Player currentPlayer;

    public GameMap() {}

    // @Phi
    // Update data of this map when game send on init map event
    public void updateOnInitMap(String arg) {
        try {
            Gson gson = new Gson();
//            String message = MsgPackUtil.decode(arg);

            String message = arg;
            System.out.println("Message from server: " + message);

            MapData mapData = gson.fromJson(message, MapData.class);

            setMapSize(mapData.mapSize);

            for(Obstacle o : mapData.listIndestrucible){
                Obstacle indestructible = ObstacleFactory.getObstacle("INDESTRUCTIBLE_OBSTACLE", o.getX(), o.getY());
                listIndestructibleObstacles.add(indestructible);
            }



        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // @Phi
    // Update data of this map when game send on update map event
    public void updateOnUpdateMap(String arg) {
        try {
//            String message = MsgPackUtil.decode(arg);

            String message = arg;
            System.out.println("Message from server: " + message);
            Gson gson = new Gson();

            MapData mapData = gson.fromJson(message, MapData.class);

            List<Enemy> newListEnemies = new ArrayList<>();
            List<Obstacle> newListTraps = new ArrayList<>();
            List<Obstacle> newListChests = new ArrayList<>();
            List<Weapon> newListWeapons = new ArrayList<>();
            List<HealingItem> newListHealingItem = new ArrayList<>();
            List<Armor> newListArmor = new ArrayList<>();

            setDarkAreaSize(mapData.darkAreaSize);

            for(Enemy e : mapData.listEnemies){
                Enemy enemy = EnemyFactory.getEnemy(e.getId(), e.getX(), e.getY());
                newListEnemies.add(enemy);
            }
            setListEnemies(newListEnemies);

            for(Obstacle t : mapData.listTraps) {
                Obstacle trap = ObstacleFactory.getObstacle(t.getId(), t.getX(), t.getY());
                newListTraps.add(trap);
            }
            setListTraps(newListTraps);

            for(Obstacle c : mapData.listChests) {
                Obstacle chest = ObstacleFactory.getObstacle(c.getId(), c.getX(), c.getY());
                newListChests.add(chest);
            }
            setListChests(newListChests);

            for(Weapon w : mapData.listWeapons){
                Weapon weapon = WeaponFactory.getWeapon(w.getId(), w.getX(), w.getY());
                newListWeapons.add(weapon);
            }
            setListWeapons(newListWeapons);

            for(HealingItem h: mapData.listHealingItems){
                HealingItem healing = HealingItemFactory.getHealingItem(h.getId(), h.getX(),h.getY());
                newListHealingItem.add(healing);
            }
            setListHealingItems(newListHealingItem);

            for (Armor a: mapData.listArmors) {
                Armor armor = ArmorFactory.getArmor(a.getId(),a.getX(),a.getY());
                newListArmor.add(armor);
            }
            setListArmors(newListArmor);

            List<Bullet> newBullets = new ArrayList<>(mapData.listBullet);
            for(Bullet b : newBullets){
                b.setId("BULLET");
                b.setType(ElementType.BULLET);
            }
            setListBullets(newBullets);

            List<Player> newOtherPlayersInfo = new ArrayList<>(mapData.players);
            setOtherPlayerInfo(newOtherPlayersInfo);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    // @Phi
    // Get element by index on map
    public Element getElementByIndex(int x, int y) {
        // return default element is road
        return new Element(x, y, "ROAD", ElementType.ROAD);
    }

    public List<Weapon> getAllGun() {
        List<Weapon> guns = new ArrayList<>();
        for (Weapon weapon : listWeapons) {
            if (weapon.getType() == ElementType.GUN) {
                guns.add(weapon);
            }
        }
        return guns;
    }

    public List<Weapon> getAllMelee() {
        List<Weapon> melees = new ArrayList<>();
        for (Weapon weapon : listWeapons) {
            if (weapon.getType() == ElementType.MELEE) {
                melees.add(weapon);
            }
        }
        return melees;
    }

    public List<Weapon> getAllThrowable() {
        List<Weapon> throwables = new ArrayList<>();
        for (Weapon weapon : listWeapons) {
            if (weapon.getType() == ElementType.THROWABLE) {
                throwables.add(weapon);
            }
        }
        return throwables;
    }

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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public void setDarkAreaSize(int darkAreaSize) {
        this.darkAreaSize = darkAreaSize;
    }

    public void setListIndestructibleObstacles(List<Obstacle> listIndestructibleObstacles) {
        this.listIndestructibleObstacles = listIndestructibleObstacles;
    }

    public void setListEnemies(List<Enemy> listEnemies) {
        this.listEnemies = listEnemies;
    }

    public void setListTraps(List<Obstacle> listTraps) {
        this.listTraps = listTraps;
    }

    public void setListChests(List<Obstacle> listChests) {
        this.listChests = listChests;
    }

    public void setListWeapons(List<Weapon> listWeapons) {
        this.listWeapons = listWeapons;
    }

    public void setListHealingItems(List<HealingItem> listHealingItems) {
        this.listHealingItems = listHealingItems;
    }

    public void setListArmors(List<Armor> listArmors) {
        this.listArmors = listArmors;
    }

    public void setListBullets(List<Bullet> listBullets) {
        this.listBullets = listBullets;
    }

    public void setOtherPlayerInfo(List<Player> otherPlayerInfo) {
        this.otherPlayerInfo = otherPlayerInfo;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    
}
