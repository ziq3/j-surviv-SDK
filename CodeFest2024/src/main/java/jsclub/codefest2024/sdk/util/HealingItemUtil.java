package jsclub.codefest2024.sdk.util;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.sdk.socket.data.Equipments.HealingItem;

public class HealingItemUtil {
    public static Map<String, HealingItem> createHealingItemsMap() {
        Map<String, HealingItem> healingItemList = new HashMap<>();
        healingItemList.put("SNACK", new HealingItem(10, 1000, 1));
        healingItemList.put("INSECTICIDE", new HealingItem(15, 1500, 1));
        healingItemList.put("DRINK", new HealingItem(20, 2000, 1));
        healingItemList.put("BANDAGES", new HealingItem(50, 3000, 2));
        healingItemList.put("LUNCH_BOX", new HealingItem(100, 4000, 3));
        return healingItemList;
    }

    public Map<String, HealingItem> healingItemList;

    public HealingItemUtil() {
        this.healingItemList = createHealingItemsMap();
    }

    @Override
    public String toString() {
        return new Gson().toJson(healingItemList);
    }

    public HealingItem getHealingItem(String name) {
        return healingItemList.get(name);
    }
}
