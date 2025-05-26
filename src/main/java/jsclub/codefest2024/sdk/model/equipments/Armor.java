package jsclub.codefest2024.sdk.model.equipments;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Armor extends Element {
    private final int damageReduce;
    private final int healPoint;

    public Armor(String id, int damageReduce, int healPoint) {
        super(id);
        this.damageReduce = damageReduce;
        this.healPoint = healPoint;
        this.setType(ElementType.ARMOR);
    }

    public int getPoint() {
        return healPoint;
    }

    /**
     * Get reduced damage percentage
     * @return percentage of damage reduce
     */
    public int getDamageReduce() {
        return damageReduce;
    }
}
