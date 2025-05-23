package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.util.HashMap;
import java.util.Map;
import jsclub.codefest2024.sdk.model.weapon.AttackRange;
import jsclub.codefest2024.sdk.model.weapon.Bullet;

public class WeaponFactory {
    /**
     * Available Weapons
     */
    private static final Map<String, Weapon> weaponMap = new HashMap<>();

    static {
        weaponMap.put("KNIFE", new Weapon("KNIFE", ElementType.MELEE, 20, 55, 25, 2.5, 0, 25, 3, 0, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("TREE_BRANCH", new Weapon("TREE_BRANCH", ElementType.MELEE, 25, 35, 10, 0.5, 0, 10, 3, 0, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("HAND", new Weapon("HAND", ElementType.MELEE, 0, 0, 5, 0.5, 0, 5, 1, 0, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("BONE", new Weapon("BONE", ElementType.MELEE, 35, 45, 20, 2, 0, 20, 3, 0, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("AXE", new Weapon("AXE", ElementType.MELEE, 20, 45, 45, 3, 0, 45, 3, 0, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("MAGIC_STICK", new Weapon("MAGIC_STICK", ElementType.GUN, 25, 40, 20, 1, 10, 0, 12, 0, AttackRange.LONG, new Bullet(20, 6)));
        weaponMap.put("CROSSBOW", new Weapon("CROSSBOW", ElementType.GUN, 20, 35, 25, 1.5, 5, 25, 4, 0, AttackRange.LONG, new Bullet(25, 4)));
        weaponMap.put("RUBBER_GUN", new Weapon("RUBBER_GUN", ElementType.GUN, 35, 50, 10, 1, 10, 10, 12, 0, AttackRange.LONG, new Bullet(10, 4)));
        weaponMap.put("SHOTGUN", new Weapon("SHOTGUN", ElementType.GUN, 20, 20, 40, 4, 5, 40, 2, 0, AttackRange.LONG, new Bullet(40, 8)));
        weaponMap.put("METEORITE_FRAGMENT", new Weapon("METEORITE_FRAGMENT", ElementType.THROWABLE, 30, 15, 60, 2, 0, 60, 6, 9, AttackRange.LONG, new Bullet(60, 6)));
        weaponMap.put("CRYSTAL", new Weapon("CRYSTAL", ElementType.THROWABLE, 20, 30, 60, 2, 0, 60, 6, 9, AttackRange.LONG, new Bullet(60, 6)));
        weaponMap.put("SEED", new Weapon("SEED", ElementType.THROWABLE, 15, 45, 30, 10, 2, 30, 5, 9, AttackRange.LONG, new Bullet(30, 6)));
        weaponMap.put("BOMB", new Weapon("BOMB", ElementType.SPECIAL, 5, 20, 130, 0, 1, 130, 1, 25, AttackRange.SHORT, new Bullet(0, 0)));
        weaponMap.put("SAHUR_BAT", new Weapon("SAHUR_BAT", ElementType.SPECIAL, 13, 70, 20, 10, 3, 20, 5, 0, AttackRange.LONG, new Bullet(20, 5)));


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
     * @param id  String to find weapon.
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
