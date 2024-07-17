package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.socket.data.Equipments.Armor;

public class ArmorUtil {
    public static Map<String, Armor> createArmorMap() {
        Map<String, Armor> ArmorList = new HashMap<>();
        ArmorList.put("VEST", new Armor(1, 0.2, 0, 3));
        ArmorList.put("POT", new Armor(1, 0.1, 0, 2));
        ArmorList.put("HELMET", new Armor(1, 0.05, 0, 1));

        return ArmorList;
    }

    public Map<String, Armor> ArmorList;

    public ArmorUtil() {
        ArmorList = createArmorMap();
    }

    @Override
    public String toString() {
        return new Gson().toJson(ArmorList);
    }

    public Armor getArmor(String name) {
        return ArmorList.get(name);
    }
}
