package jsclub.codefest2024.sdk.model;

import com.google.gson.annotations.SerializedName;
import jsclub.codefest2024.sdk.factory.ArmorFactory;
import jsclub.codefest2024.sdk.factory.HealingItemFactory;
import jsclub.codefest2024.sdk.factory.WeaponFactory;
import jsclub.codefest2024.sdk.model.equipments.Armor;
import jsclub.codefest2024.sdk.model.equipments.HealingItem;
import jsclub.codefest2024.sdk.model.weapon.Weapon;
import jsclub.codefest2024.sdk.socket.data.receive_data.ItemData;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    @SerializedName("ranged")
    private Weapon gun;
    @SerializedName("melee")
    private Weapon melee;
    @SerializedName("thrown")
    private Weapon throwable;
    @SerializedName("special")
    private Weapon special;
    @SerializedName("armor")
    private Armor armor;
    @SerializedName("helmet")
    private Armor helmet;
//    @SerializedName("item1")
//    private HealingItem item1;
//
//    @SerializedName("item2")
//    private HealingItem item2;
//
//    @SerializedName("item3")
//    private HealingItem item3;
//
//    @SerializedName("item4")
//    private HealingItem item4;

    private List<HealingItem> listHealingItem = new ArrayList<>();

    public Inventory(List<ItemData> items) {
        for (ItemData n : items) {
            if (n.getType().equals(ElementType.GUN))
                this.gun = WeaponFactory.getWeaponById(n.getID());
            if (n.getType().equals(ElementType.MELEE))
                this.melee =  WeaponFactory.getWeaponById(n.getID());
            if (n.getType().equals(ElementType.THROWABLE))
                this.throwable =  WeaponFactory.getWeaponById(n.getID());
            if (n.getType().equals(ElementType.SPECIAL))
                this.special =  WeaponFactory.getWeaponById(n.getID());
            if (n.getType().equals(ElementType.ARMOR))
                this.armor = ArmorFactory.getArmorById(n.getID());
            if (n.getType().equals(ElementType.HELMET))
                this.helmet = ArmorFactory.getArmorById(n.getID());
            if (n.getType().equals(ElementType.HEALING_ITEM)) {
                if (listHealingItem.size() < 4)
                    this.listHealingItem.add(HealingItemFactory.getHealingItemById(n.getID()));
                else
                    System.out.println("Full Item");
            }
        }

    }

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

    public Weapon getSpecial() {
        return special;
    }

    public void setSpecial(Weapon special) {
        this.special = special;
    }

    public Armor getHelmet() {
        return helmet;
    }

    public void setHelmet(Armor helmet) {
        this.helmet = helmet;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

//    public HealingItem getItem1() {
//        return item1;
//    }
//
//    public void setItem1(HealingItem item1) {
//        this.item1 = item1;
//    }
//
//    public HealingItem getItem2() {
//        return item2;
//    }
//
//    public void setItem2(HealingItem item2) {
//        this.item2 = item2;
//    }
//
//    public HealingItem getItem3() {
//        return item3;
//    }
//
//    public void setItem3(HealingItem item3) {
//        this.item3 = item3;
//    }
//
//    public HealingItem getItem4() {
//        return item4;
//    }
//
//    public void setItem4(HealingItem item4) {
//        this.item4 = item4;
//}

public List<HealingItem> getListHealingItem() {
    return listHealingItem;
}

public void setListHealingItem(List<HealingItem> listHealingItem) {
    this.listHealingItem = listHealingItem;
}

//    public List<Armor> getListArmor() {
//        return listArmor;
//    }

//    public void setListArmor(List<Armor> listArmor) {
//        this.listArmor = listArmor;
//    }

public void reset() {
    this.setGun(null);
    this.setMelee(WeaponFactory.getWeaponById("HAND"));
    this.setThrowable(null);
    this.setSpecial(null);
    this.setArmor(null);
    this.setHelmet(null);
//    this.setItem1(null);
//    this.setItem2(null);
//    this.setItem3(null);
//    this.setItem4(null);
    this.setListHealingItem(null);

}
}

