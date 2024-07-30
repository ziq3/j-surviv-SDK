package jsclub.codefest2024.sdk.socket.data.Map;

import jsclub.codefest2024.sdk.socket.data.enemies.Chaser;
import jsclub.codefest2024.sdk.socket.data.enemies.Crow;
import jsclub.codefest2024.sdk.socket.data.enemies.DarkArea;
import jsclub.codefest2024.sdk.socket.data.equipments.Armor;
import jsclub.codefest2024.sdk.socket.data.equipments.HealingItem;
import jsclub.codefest2024.sdk.socket.data.obstacles.Obstacle;
import jsclub.codefest2024.sdk.socket.data.weapon.Weapon;

import java.util.List;

public class MapUpdate {

    private List<Chaser> chasers;
    private List<Crow> crows;
    private List<Armor> armors;
    private List<DarkArea> darkAreas;
    private List<HealingItem> healingItems;
    private List<Obstacle> obstacles;
    private List<Weapon> weapons;


    public MapUpdate(
            List<Weapon> weapons,
            List<Obstacle> obstacles,
            List<HealingItem> healingItems,
            List<DarkArea> darkAreas,
            List<Armor> armors,
            List<Crow> crows,
            List<Chaser> chasers) {

        this.weapons = weapons;
        this.obstacles = obstacles;
        this.healingItems = healingItems;
        this.darkAreas = darkAreas;
        this.armors = armors;
        this.crows = crows;
        this.chasers = chasers;
    }

    public List<Chaser> getChasers() {
        return chasers;
    }

    public List<Crow> getCrows() {
        return crows;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public List<HealingItem> getHealingItems() {
        return healingItems;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<DarkArea> getDarkAreas() {
        return darkAreas;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setHealingItems(List<HealingItem> healingItems) {
        this.healingItems = healingItems;
    }

    public void setDarkAreas(List<DarkArea> darkAreas) {
        this.darkAreas = darkAreas;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }

    public void setCrows(List<Crow> crows) {
        this.crows = crows;
    }

    public void setChasers(List<Chaser> chasers) {
        this.chasers = chasers;
    }
}
