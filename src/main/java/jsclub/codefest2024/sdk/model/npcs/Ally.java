package jsclub.codefest2024.sdk.model.npcs;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Ally extends Element {
    private final int hp;
    private final int cooldown;

    public Ally(String id, int hp, int cooldown) {
        super(id);
        this.hp = hp;
        this.cooldown = cooldown;
        this.setType(ElementType.ALLY);
    }

    public int getHp() {
        return hp;
    }

    public int getCooldown() {
        return cooldown;
    }
}
