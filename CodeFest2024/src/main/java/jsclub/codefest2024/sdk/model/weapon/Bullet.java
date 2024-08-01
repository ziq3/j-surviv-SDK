package jsclub.codefest2024.sdk.model.weapon;

import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Bullet extends Element {
    private int damage = 0;
    private int speed = 0;
    private int destination_x = 0;
    private int destination_y = 0;
    private ElementType type = ElementType.BULLET;
    private String id = "BULLET";
}
