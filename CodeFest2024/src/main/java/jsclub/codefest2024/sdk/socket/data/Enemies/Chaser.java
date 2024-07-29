package jsclub.codefest2024.sdk.socket.data.Enemies;

import com.google.gson.Gson;

public class Chaser {
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
