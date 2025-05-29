package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.equipments.HealingItem;

import java.util.Map;

public class HealingItemFactory {
    /**
     * Available HealingItems
     */
    public static final Map<String, HealingItem> healingItemMap = Map.of(
        "GOD_LEAF", new HealingItem("GOD_LEAF", ElementType.HEALING_ITEM, 25, 0.5, 10, 0, 5, null),
        "SPIRIT_TEAR", new HealingItem("SPIRIT_TEAR", ElementType.HEALING_ITEM, 20, 0.5, 15, 0, 15, null),
        "MERMAID_TAIL", new HealingItem("MERMAID_TAIL", ElementType.HEALING_ITEM, 15, 1, 20, 0, 20, null),
        "PHOENIX_FEATHERS", new HealingItem("PHOENIX_FEATHERS", ElementType.HEALING_ITEM, 10, 1.5, 40, 0, 25, null),
        "UNICORN_BLOOD", new HealingItem("UNICORN_BLOOD", ElementType.HEALING_ITEM, 5, 3, 80, 0, 30, null),
            "ELIXER", new HealingItem("ELIXER", ElementType.SPECIAL, 5, 0, 5, 7, 30, EffectFactory.getEffects("CONTROL_IMMUNITY")),
            "MAGIC", new HealingItem("MAGIC", ElementType.SPECIAL, 5, 0, 0, 5, 30, EffectFactory.getEffects("INVISIBLE")),
            "ELIXER_OF_LIFE", new HealingItem("ELIXER_OF_LIFE", ElementType.SPECIAL, 5, 0, 100, 0, 30, EffectFactory.getEffects("REVIVAL"), EffectFactory.getEffects("UNDEAD")),
            "COMPASS", new HealingItem("COMPASS", ElementType.SPECIAL, -1, 2, 0, 7, 60, EffectFactory.getEffects("STUN"))


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
