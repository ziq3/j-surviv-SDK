package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.socket.data.Equipments.HealingItem;

public class HealingItemUtil {
    public static Map<String, HealingItem> createHealingItemsMap() {
        Map<String, HealingItem> HealingItemList = new HashMap<>();
        HealingItemList.put("SNACK", new HealingItem(10, 1, 1000, 5, 1));
        HealingItemList.put("INSECTICIDE", new HealingItem(15, 1, 1500, 7, 1));
        HealingItemList.put("DRINK", new HealingItem(20, 1, 2000, 10, 1));
        HealingItemList.put("BANDAGES", new HealingItem(50, 1, 3000, 25, 2));
        HealingItemList.put("LUNCH_BOX", new HealingItem(100, 1, 4000, 51, 3));
        return HealingItemList;
    }

    public Map<String, HealingItem> HealingItemList;

    public HealingItemUtil() {
        HealingItemList = createHealingItemsMap();
    }

    @Override
    public String toString() {
        return new Gson().toJson(HealingItemList);
    }

    public HealingItem getHealingItem(String name) {
        return HealingItemList.get(name);
    }
}
