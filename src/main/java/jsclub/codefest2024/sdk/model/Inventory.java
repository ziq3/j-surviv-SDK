package jsclub.codefest2024.sdk.model;

import jsclub.codefest2024.sdk.factory.WeaponFactory;
import jsclub.codefest2024.sdk.model.equipments.Armor;
import jsclub.codefest2024.sdk.model.equipments.HealingItem;
import jsclub.codefest2024.sdk.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon gun;
    private Weapon melee;
    private Weapon throwable;
    private List<Armor> listArmor;
    private List<HealingItem> listHealingItem = new ArrayList<>();

    public Inventory() {
        // Set default value for melee is HAND
        this.melee = WeaponFactory.getWeaponById("HAND");
    }

    public Weapon getGun() {
        return gun;
    }

    public void setGun(Weapon gun) {
        this.gun = gun;
    }

    public Weapon getMelee() {
        return melee;
    }

    public void setMelee(Weapon melee) {
        this.melee = melee;
    }

    public Weapon getThrowable() {
        return throwable;
    }

    public void setThrowable(Weapon throwable) {
        this.throwable = throwable;
    }

    public List<HealingItem> getListHealingItem() {
        return listHealingItem;
    }

    public void setListHealingItem(List<HealingItem> listHealingItem) {
        this.listHealingItem = listHealingItem;
    }

    public List<Armor> getListArmor() {
        return listArmor;
    }

    public void setListArmor(List<Armor> listArmor) {
        this.listArmor = listArmor;
    }
}
