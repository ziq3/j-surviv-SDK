package jsclub.codefest.sdk.model.weapon;

import com.google.gson.annotations.SerializedName;
import jsclub.codefest.sdk.model.Element;
import jsclub.codefest.sdk.model.ElementType;

public class Bullet extends Element {
    private int damage = 0;
    private int speed = 0;

    @SerializedName("destination_x")
    private final int destinationX = 0;

    @SerializedName("destination_y")
    private final int destinationY = 0;

    public Bullet() {
        setId("BULLET");
        setType(ElementType.BULLET);
    }

    public Bullet(int damage, int speed) {
        setId("BULLET");
        setType(ElementType.BULLET);
        this.damage = damage;
        this.speed = speed;
    }
    
    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }
}
