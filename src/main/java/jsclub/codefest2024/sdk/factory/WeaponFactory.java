package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponFactory {
    /**
     * Available Weapons
     */
    private static final Map<String, Weapon> weaponMap = new HashMap<>();
    static {
        weaponMap.put("WATER_GUN", new Weapon("WATER_GUN", ElementType.GUN, 30, 60, 5, 4));
        weaponMap.put("LEGO_GUN", new Weapon("LEGO_GUN", ElementType.GUN, 25, 50, 5, 4));
        weaponMap.put("RUBBER_GUN", new Weapon("RUBBER_GUN", ElementType.GUN, 20, 40, 10, 4));
        weaponMap.put("BADMINTON", new Weapon("BADMINTON", ElementType.GUN, 20, 40, 10, 4));
        weaponMap.put("BROOM", new Weapon("BROOM", ElementType.MELEE, 45, 90, 0, 1));
        weaponMap.put("SANDAL", new Weapon("SANDAL", ElementType.MELEE, 45, 90, 0, 1));
        weaponMap.put("LIGHT_SABER", new Weapon("LIGHT_SABER", ElementType.MELEE, 55, 110, 0, 1));
        weaponMap.put("HAND", new Weapon("HAND", ElementType.MELEE, 5, 10, 0, 1));
        weaponMap.put("PAPER_AIRPLANE", new Weapon("PAPER_AIRPLANE", ElementType.THROWABLE, 25, 50, 0, 6));
        weaponMap.put("BALL", new Weapon("BALL", ElementType.THROWABLE, 25, 50, 0, 6));
        weaponMap.put("PAPER_DART", new Weapon("PAPER_DART", ElementType.THROWABLE, 25, 50, 0, 6));
        weaponMap.put("TEDDY_BEAR", new Weapon("TEDDY_BEAR", ElementType.THROWABLE, 25, 50, 0, 6));
        weaponMap.put("WATER_BALL", new Weapon("WATER_BALL", ElementType.THROWABLE, 25, 50, 0, 6));
    }

    /**
     * Find weapon by id.
     *
     * @param id String to find weapon.
     * @return Weapon mapped with id.
     */
    public static Weapon getWeaponById(String id) {
        return weaponMap.get(id);
    }

    /**
     * Find weapon by id.
     * Set position for weapon
     *
     * @param id String to find weapon.
     * @param x,y int to set position.
     * @return Weapon with updated position,id.
     * @throws CloneNotSupportedException If clone is not supported.
     */
    public static Weapon getWeapon(String id, int x, int y) throws CloneNotSupportedException {
        Weapon weaponBase = weaponMap.get(id);

        Weapon weapon = (Weapon) weaponBase.clone();
        weapon.setPosition(x, y);
        weapon.setId(id);
        return weapon;
    }
}
