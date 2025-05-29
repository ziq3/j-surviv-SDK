package jsclub.codefest2024.sdk.model.obstacles;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Obstacle extends Element {
    private int hp = -1;
    private ObstacleTag tag = ObstacleTag.INDESTRUCTIBLE;

    public Obstacle(String id, ElementType type, ObstacleTag tag , int hp) {
        super(id);
        this.tag = tag;
        this.hp = hp;
        this.setType(type);
    }

    public Obstacle(String id, ElementType type, ObstacleTag tag) {
        super(id);
        this.tag = tag;
        this.setType(type);
    }

    public int getHp() {
        return hp;
    }

    public ObstacleTag getTag() {
        return tag;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setTag(ObstacleTag tag) {
        this.tag = tag;
    }
}
