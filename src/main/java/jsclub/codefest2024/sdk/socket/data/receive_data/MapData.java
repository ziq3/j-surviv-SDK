package jsclub.codefest2024.sdk.socket.data.receive_data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.buildings.Building;
import jsclub.codefest2024.sdk.model.npcs.Enemy;
import jsclub.codefest2024.sdk.factory.EnemyFactory;
import jsclub.codefest2024.sdk.model.npcs.Ally;
import jsclub.codefest2024.sdk.factory.AllyFactory;
import jsclub.codefest2024.sdk.factory.ArmorFactory;
import jsclub.codefest2024.sdk.model.equipments.Armor;
import jsclub.codefest2024.sdk.model.equipments.HealingItem;
import jsclub.codefest2024.sdk.factory.HealingItemFactory;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;
import jsclub.codefest2024.sdk.factory.ObstacleFactory;
import jsclub.codefest2024.sdk.factory.WeaponFactory;
import jsclub.codefest2024.sdk.model.players.Player;
import jsclub.codefest2024.sdk.model.weapon.Bullet;
import jsclub.codefest2024.sdk.model.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;

public class MapData {
    @SerializedName("mapSize")
    public int mapSize;

    @SerializedName("obstacles")
    public List<Obstacle> listObstacles;

    @SerializedName("buildings")
    public List<Building> listBuildings;

    @SerializedName("safeZoneRadius")
    public int safeZone;
    
    @SerializedName("isAccentWallOpened")
    public boolean isAccentWallOpened;

    @SerializedName("entities")
    public List<Entity> listEntities;

    // @SerializedName("blocks")
    // public List<Block> listBlocks;

    // @SerializedName("traps")
    // public List<Obstacle> listTraps;

    // @SerializedName("listChests")
    // public List<Obstacle> listChests;

    // @SerializedName("structures")
    // public List<Structure> listStructures;

    @SerializedName("otherPlayers")
    public List<Player> otherPlayers;

    @SerializedName("currentPlayer")
    public Player currentPlayer;

    // Categorize
    public List<Enemy> listEnemies = new ArrayList<>();
    public List<Ally> listAllies = new ArrayList<>();
    public List<Weapon> listWeapons = new ArrayList<>();
    public List<HealingItem> listHealingItems = new ArrayList<>();
    public List<Armor> listArmors = new ArrayList<>();
    public List<Bullet> listBullet = new ArrayList<>();

    public void categorizeMapData() throws CloneNotSupportedException {

        for (Entity e : listEntities) {
            if (e.type == ElementType.OBSTACLE) {
                Obstacle obstacle = ObstacleFactory.getObstacle(e.id, e.x, e.y);
                listObstacles.add(obstacle);
            }

            if (e.type == ElementType.ENEMY) {
                Enemy enemy = EnemyFactory.getEnemy(e.id, e.x, e.y);
                listEnemies.add(enemy);
            }
            
            if (e.type == ElementType.ALLY) {
                Ally ally = AllyFactory.getAlly(e.id, e.x, e.y);
                listAllies.add(ally);
            }

            if (e.type == ElementType.MELEE
             || e.type == ElementType.THROWABLE
             || e.type == ElementType.GUN
             || e.type == ElementType.SPECIAL) {
                Weapon weapon = WeaponFactory.getWeapon(e.id, e.x, e.y);
                listWeapons.add(weapon);
            }

            if (e.type == ElementType.HEALING_ITEM) {
                HealingItem healing = HealingItemFactory.getHealingItem(e.id, e.x, e.y);
                listHealingItems.add(healing);
            }

            if (e.type == ElementType.ARMOR) {
                Armor armor = ArmorFactory.getArmor(e.id, e.x, e.y);
                listArmors.add(armor);
            }

            if (e.type == ElementType.BULLET) {
                Bullet b = new Bullet();
                listBullet.add(b);
            }
        }
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
