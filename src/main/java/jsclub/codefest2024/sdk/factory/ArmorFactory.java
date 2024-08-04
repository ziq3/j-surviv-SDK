package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.equipments.Armor;

import java.util.Map;

public class ArmorFactory {
    public static final Map<String, Armor> armorMap = Map.of(
        "VEST", new Armor("VEST", 20, 3),
        "POT", new Armor("POT", 20, 2),
        "HELMET", new Armor("HELMET", 20, 1)
    );

    public static Armor getArmorById(String id) {
        return armorMap.get(id);
    }

    public static Armor getArmor(String id, int x, int y) throws CloneNotSupportedException {
        Armor armorBase = getArmorById(id);

        Armor armor = (Armor) armorBase.clone();
        armor.setPosition(x, y);
        armor.setId(id);
        return armor;
    }
}
