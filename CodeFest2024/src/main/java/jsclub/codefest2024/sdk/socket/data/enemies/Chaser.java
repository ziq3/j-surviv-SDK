package jsclub.codefest2024.sdk.socket.data.enemies;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.data.element.Element;

public class Chaser extends Element {
    public int damage;

    public Chaser(int damage) {
        this.damage = damage;
    }

    public void setDamge(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
