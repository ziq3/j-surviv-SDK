package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import jsclub.codefest2024.socket.data.Weapon.Weapon;

public class WeaponUtil {
    public static Map<String, Weapon> createWeaponsMap() {
        Map<String, Weapon> weaponList = new HashMap<>();

        weaponList.put("WATER_GUN", new Weapon("Guns", 1, 1, 10, 10, 20, null, 20, 2, 20, 3, 4, 0));
        weaponList.put("LEGO_GUN", new Weapon("Guns", 1, 1, 1, 15, 10, null, 15, 1, 10, 3, 4, 0));
        weaponList.put("RUBBER_GUN", new Weapon("Guns", 1, 1, 1, 7, 10, null, 15, 1, 10, 3, 4, 0));
        weaponList.put("BADMINTON", new Weapon("Guns", 1, 1, 1, 5, 10, null, 15, 1, 5, 3, 4, 0));
        weaponList.put("BROOM", new Weapon("Melee", 1, 1, 3, 20, 25, 0.9, 25, 1, 0, 0, 2, 0));
        weaponList.put("SANDAL", new Weapon("Melee", 1, 1, 3, 20, 25, 0.9, 25, 1, 0, 0, 2, 0));
        weaponList.put("LIGHT_SABER", new Weapon("Melee", 1, 1, 2, 15, 20, 0.6, 20, 1, 0, 0, 2, 0));
        weaponList.put("HAND", new Weapon("Melee", 1, 1, 1, 5, 10, null, 10, 1, 0, 0, 1, 0));
        weaponList.put("PAPER_AIRPLANE", new Weapon("Throwables", 1, 1, 2, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("BALL", new Weapon("Throwables", 1, 1, 2, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("PAPER_DART", new Weapon("Throwables", 1, 1, 1, 10, 10, 1.0, 10, 1, 0, 0, 5, 3));
        weaponList.put("TEDDY_BEAR", new Weapon("Throwables", 1, 1, 1, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("WATER_BALL", new Weapon("Throwables", 1, 1, 2, 10, 15, 0.6, 15, 1, 0, 0, 5, 3));

        return weaponList;
    }

    public Map<String, Weapon> WeaponList;

    public WeaponUtil() {
        WeaponList = createWeaponsMap();
    }

    public String toString() {
        return new Gson().toJson(WeaponList);
    }

    public Weapon getWeapon(String name) {
        return WeaponList.get(name);
    }
}
