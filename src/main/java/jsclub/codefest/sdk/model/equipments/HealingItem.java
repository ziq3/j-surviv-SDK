package jsclub.codefest.sdk.model.equipments;

import jsclub.codefest.sdk.model.Element;
import jsclub.codefest.sdk.model.ElementType;
import jsclub.codefest.sdk.model.effects.Effect;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HealingItem extends Element {
    private int rarity;
    private int duration;

    private final int healingHP;
    private final double usageTime;
    private final int point;
    private ArrayList<Effect> effects;


    public HealingItem(String id, ElementType type, int rarity, double usageTime, int healingHp, int duration, int point, Effect... effects) {
        super(id);
        this.rarity = rarity;
        this.duration = duration;
        this.healingHP = healingHp;
        this.usageTime = usageTime;
        this.point = point;

        this.setType(type);
        this.effects = new ArrayList<>(Arrays.asList(effects));
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
