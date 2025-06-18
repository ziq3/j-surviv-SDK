package jsclub.codefest.sdk.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import jsclub.codefest.sdk.model.buildings.Building;
import jsclub.codefest.sdk.base.Node;
import jsclub.codefest.sdk.factory.*;
import jsclub.codefest.sdk.model.npcs.*;
import jsclub.codefest.sdk.model.equipments.*;
import jsclub.codefest.sdk.model.obstacles.*;
import jsclub.codefest.sdk.model.players.Player;
import jsclub.codefest.sdk.model.weapon.*;
import jsclub.codefest.sdk.socket.data.receive_data.Entity;
import jsclub.codefest.sdk.socket.data.receive_data.MapData;
import jsclub.codefest.sdk.socket.data.receive_data.Structure;
import jsclub.codefest.sdk.util.MsgPackUtil;

public class GameMap {
    private int mapSize = 0;
    private int safeZone = 0;
    private int darkAreaSize = 0;
    private List<Obstacle> listIndestructibleObstacles = new ArrayList<>();
    private List<Obstacle> listObstacles = new ArrayList<>();
    private List<Building> listBuildings = new ArrayList<>();
    private List<Enemy> listEnemies = new ArrayList<>();
    private List<Ally> listAllies = new ArrayList<>();
    private List<Weapon> listWeapons = new ArrayList<>();
    private List<HealingItem> listHealingItems = new ArrayList<>();
    private List<Armor> listArmors = new ArrayList<>();
    private List<Bullet> listBullets = new ArrayList<>();
    private List<Player> otherPlayerInfo = new ArrayList<>();
    private Player currentPlayer;
    private Inventory heroInventory;


    public GameMap(Inventory heroInventory) {
        this.heroInventory = heroInventory;
    }

    /**
     * Decode message from server when initializing map.
     * update map size and indestructible obstacles attributes
     *
     * @param arg The message parsed from server.
     */
    public void updateOnInitMap(Object arg) {
        try {
            Gson gson = new Gson();
            String message = MsgPackUtil.decode(arg);
            System.out.println(message);
            MapData mapData = gson.fromJson(message, MapData.class);
            setMapSize(mapData.mapSize);

            List<Obstacle> newListObstacles = new ArrayList<>();
            List<Building> newListBuildings = new ArrayList<>();
            
            for (Obstacle o : mapData.listObstacles){
                Obstacle obstacle = ObstacleFactory.getObstacle(o.getId(), o.x, o.y);
                newListObstacles.add(obstacle);
            }
            setListObstacles(newListObstacles);

            for (Structure b : mapData.listBuildings) {
                Node limitPos = new Node(b.xBottomRight, b.yBottomRight);
                Node landmarkPos = new Node(b.xTopLeft, b.yTopLeft);
                Building building = BuildingFactory.getBuilding(b.id, limitPos, landmarkPos);
                newListBuildings.add(building);
            }
            setListBuildings(newListBuildings);

//            System.out.println("mapData"+getListObstacles());
        } catch (CloneNotSupportedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Decode message from server when updating map.
     * update dark area size and items information
     *
     * @param arg The message parsed from server.
     */
    public void updateOnUpdateMap(Object arg) {
        try {
            Gson gson = new Gson();
            String message = MsgPackUtil.decode(arg);
            System.out.println("map update"+message);
            MapData mapData = gson.fromJson(message, MapData.class);

            List<Obstacle> newListObstacles = new ArrayList<>();
            List<Enemy> newListEnemies = new ArrayList<>();
            List<Ally> newListAllies = new ArrayList<>();
            List<Weapon> newListWeapons = new ArrayList<>();
            List<HealingItem> newListHealingItem = new ArrayList<>();
            List<Armor> newListArmor = new ArrayList<>();
            // List<Bullet> newListBullets = new ArrayList<>();

            setSafeZone(mapData.safeZone);

//            for (Obstacle o : mapData.listObstacles){
//                Obstacle obstacle = ObstacleFactory.getObstacle(o.getId(), o.x, o.y);
//                newListObstacles.add(obstacle);
//            }
//            setListObstacles(newListObstacles);
            
            for (Entity entity : mapData.listEntities) {
                if (entity.type == ElementType.OBSTACLE) {
                    Obstacle obstacle = ObstacleFactory.getObstacle(entity.id, entity.x, entity.y);
                    newListObstacles.add(obstacle);
                }             

                if (entity.type == ElementType.ENEMY) {
                    Enemy enemy = EnemyFactory.getEnemy(entity.id, entity.x, entity.y);
                    newListEnemies.add(enemy);
                }
                
                if (entity.type == ElementType.ALLY) {
                    Ally ally = AllyFactory.getAlly(entity.id, entity.x, entity.y);
                    newListAllies.add(ally);
                }
                
                if (entity.type == ElementType.MELEE
                 || entity.type == ElementType.THROWABLE
                 || entity.type == ElementType.GUN
                 || entity.type == ElementType.SPECIAL) {
                    Weapon weapon = WeaponFactory.getWeapon(entity.id, entity.x, entity.y);
                    newListWeapons.add(weapon);
                }
                
                if (entity.type == ElementType.HEALING_ITEM) {
                    HealingItem healing = HealingItemFactory.getHealingItem(entity.id, entity.x, entity.y);
                    newListHealingItem.add(healing);
                }
                
                if (entity.type == ElementType.ARMOR
                 || entity.type == ElementType.HELMET) {
                    Armor armor = ArmorFactory.getArmor(entity.id, entity.x, entity.y);
                    newListArmor.add(armor);
                }

                // if (entity.type == ElementType.BULLET) {
                //     Bullet b = new Bullet();
                //     newListBullets.add(b);
                // }
            }
            
            setListObstacles(newListObstacles);
            setListEnemies(newListEnemies);
            setListAllies(newListAllies);
            setListWeapons(newListWeapons);
            setListHealingItems(newListHealingItem);
            setListArmors(newListArmor);
            
            // setListBullets(mapData.listBullets);
            setOtherPlayerInfo(mapData.otherPlayers);
            setCurrentPlayer(mapData.currentPlayer);

//            if (!currentPlayer.getIsAlive()) {
//                this.heroInventory.reset();
//            }
        } catch (CloneNotSupportedException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * find element by position
     *
     * @param x,y int Position of element.
     * @return The Element mapped with position.
     */

    public Element getElementByIndex(int x, int y) {
        Element element = null;
        // element = this.findElementInListByIndex(x, y, this.listIndestructibleObstacles);
        // if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listObstacles);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listEnemies);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listAllies);
        if (element != null) return element;
        
        element = this.findElementInListByIndex(x, y, this.listWeapons);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listHealingItems);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listArmors);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.listBullets);
        if (element != null) return element;

        element = this.findElementInListByIndex(x, y, this.otherPlayerInfo);
        if (element != null) return element;

        if (this.currentPlayer.x == x && this.currentPlayer.y == y) {
            return this.currentPlayer;
        }

        return new Element(x, y, "ROAD", ElementType.ROAD);
    }

    private Element findElementInListByIndex(int x, int y, List elements) {
        for (Object element : elements) {
            Element e = (Element) element;
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    /**
     * get,set functions
     */

    public List<Obstacle> getObstaclesByTag(String tag) {
        List<Obstacle> obstacles = new ArrayList<>();
        try {
            ObstacleTag t = ObstacleTag.valueOf(tag);
            for (Obstacle o : listObstacles) {
                if (o.getTag().contains(t)) {
                    obstacles.add(o);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return obstacles;
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

    public List<Weapon> getAllSpecial() {
        List<Weapon> specials = new ArrayList<>();
        for (Weapon weapon : listWeapons) {
            if (weapon.getType() == ElementType.SPECIAL) {
                specials.add(weapon);
            }
        }
        return specials;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int getSafeZone() {
        return safeZone;
    }

    public List<Obstacle> getListIndestructibleObstacles() {
        return listIndestructibleObstacles;
    }

    public List<Obstacle> getListObstacles() {
        return listObstacles;
    }

    public List<Enemy> getListEnemies() {
        return listEnemies;
    }

    public List<Ally> getListAllies() {
        return listAllies;
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

    public List<Building> getListBuildings() {
        return listBuildings;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public void setSafeZone(int safeZone) {
        this.safeZone = safeZone;
    }

    // public void setListIndestructibleObstacles(List<Obstacle> listIndestructibleObstacles) {
    //     this.listIndestructibleObstacles = listIndestructibleObstacles;
    // }

    public void setListObstacles(List<Obstacle> listObstacles) {
        this.listObstacles = listObstacles;
    }

    public void setListEnemies(List<Enemy> listEnemies) {
        this.listEnemies = listEnemies;
    }

    public void setListAllies(List<Ally> listAllies) {
        this.listAllies = listAllies;
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

    public void setListBuildings(List<Building> listBuildings) {
        this.listBuildings = listBuildings;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
