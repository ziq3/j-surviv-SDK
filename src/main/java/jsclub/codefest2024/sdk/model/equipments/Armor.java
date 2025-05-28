package jsclub.codefest2024.sdk.model.equipments;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.effects.Effect;

import java.util.ArrayList;
import java.util.Arrays;

public class Armor extends Element {
    private final int damageReduce;
    private final int healthPoint;

    public Armor(String id, ElementType type, int rarity, int healthPoint, int damageReduce) {
        super(id);
        this.damageReduce = damageReduce;
        this.healthPoint = healthPoint;
        this.setType(type);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamageReduce() {
        return damageReduce;
    }
}
