package jsclub.codefest2024.sdk.util.element;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.sdk.socket.data.equipments.Armor;

public class ArmorUtil {
    public static Map<String, Armor> createArmorMap() {
        Map<String, Armor> armorList = new HashMap<>();
        armorList.put("VEST", new Armor(0.2, 0, 3));
        armorList.put("POT", new Armor(0.1, 0, 2));
        armorList.put("HELMET", new Armor(0.05, 0, 1));

        return armorList;
    }

    public Map<String, Armor> armorList;

    public ArmorUtil() {
        this.armorList = createArmorMap();
    }

    @Override
    public String toString() {
        return new Gson().toJson(armorList);
    }

    public Armor getArmor(String name) {
        return armorList.get(name);
    }
}
