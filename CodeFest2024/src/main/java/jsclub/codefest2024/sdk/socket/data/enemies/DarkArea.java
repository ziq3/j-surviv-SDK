package jsclub.codefest2024.sdk.socket.data.enemies;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.data.element.Element;

public class DarkArea extends Element {
    public int damage = 5;
    public String name = "DARK_AREA";
    public int width=0;

    public DarkArea(int width, int damage, String name) {
        this.width = width;
        this.damage = damage;
        this.name = name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
