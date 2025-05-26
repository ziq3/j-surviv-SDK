package jsclub.codefest2024.sdk.model.equipments;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Armor extends Element {
    private final int damageReduce;
    private final int healthPoint;

    public Armor(String id, int damageReduce, int healthPoint) {
        super(id);
        this.damageReduce = damageReduce;
        this.healthPoint = healthPoint;
        this.setType(ElementType.ARMOR);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamageReduce() {
        return damageReduce;
    }
}
