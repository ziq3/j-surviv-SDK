package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.equipments.HealingItem;

import java.util.Map;

public class HealingItemFactory {
    /**
     * Available HealingItems
     */
    public static final Map<String, HealingItem> healingItemMap = Map.of(
        "GOD_LEAF", new HealingItem("GOD_LEAF", 10, 0.5, 5),
        "SPIRIT_TEAR", new HealingItem("SPIRIT_TEAR", 15, 0.5, 15),
        "MERMAID_TAIL", new HealingItem("MERMAID_TAIL", 20, 1, 20),
        "PHOENIX_FEATHERS", new HealingItem("PHOENIX_FEATHERS", 40, 1.5, 25),
        "UNICORN_BLOOD", new HealingItem("UNICORN_BLOOD", 80, 3, 30)
    );

    /**
     * Find healing item by id.
     *
     * @param id String to find healing item.
     * @return HealingItem mapped with id.
     */
    public static HealingItem getHealingItemById(String id) {
        return healingItemMap.get(id);
    }

    /**
     * Find healing item by id.
     * Set position for healing item
     *
     * @param id String to find healing item.
     * @param x,y int to set position.
     * @return HealingItem with updated position,id.
     * @throws CloneNotSupportedException If clone is not supported.
     */
    public static HealingItem getHealingItem(String id, int x, int y) throws CloneNotSupportedException {
        HealingItem healingItemBase = getHealingItemById(id);

        HealingItem healingItem = (HealingItem) healingItemBase.clone();
        healingItem.setPosition(x, y);
        healingItem.setId(id);
        return healingItem;
    }
}
