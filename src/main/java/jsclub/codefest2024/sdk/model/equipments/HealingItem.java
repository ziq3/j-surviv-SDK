package jsclub.codefest2024.sdk.model.equipments;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class HealingItem extends Element {
    private final int healingHP;
    private final double usageTime;
    private final int point;

    public HealingItem(String id, int healingHp, double usageTime, int point) {
        super(id);
        this.healingHP = healingHp;
        this.usageTime = usageTime;
        this.point = point;
        this.setType(ElementType.HEALING_ITEM);
    }

    public int getHealingHP() {
        return healingHP;
    }

    public double getUsageTime() {
        return usageTime;
    }

    public int getPoint() {
        return point;
    }
}
