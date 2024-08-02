package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.equipments.HealingItem;

import java.util.Map;

public class HealingItemFactory {

    public static final Map<String, HealingItem> healingItemMap = Map.of(
            "SNACK", new HealingItem("SNACK", 10, 4, 1),
            "INSECTICIDE", new HealingItem("INSECTICIDE", 15, 6, 1),
            "DRINK", new HealingItem("DRINK", 20, 8, 1),
            "BANDAGES", new HealingItem("BANDAGES", 50, 12, 2),
            "LUNCH_BOX", new HealingItem("LUNCH_BOX", 100, 16, 3)
    );

    public static HealingItem getHealingItemById(String id) {
        return healingItemMap.get(id);
    }

    public static HealingItem getHealingItem(String id, int x, int y) throws CloneNotSupportedException {
        HealingItem healingItemBase = healingItemMap.get(id);

        HealingItem healingItem = (HealingItem) healingItemBase.clone();
        healingItem.setPosition(x, y);
        healingItem.setId(id);
        return healingItem;
    }
}
