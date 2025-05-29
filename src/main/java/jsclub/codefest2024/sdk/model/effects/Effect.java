package jsclub.codefest2024.sdk.model.effects;

import com.google.gson.annotations.SerializedName;

public class Effect {
    @SerializedName("id")
    private String id;

    @SerializedName("time")
    private int time;

    @SerializedName("damage")
    private int damage;

    public Effect() {
    }

    public Effect(int time, String id, int damage) {
        this.time = time;
        this.id = id;
        this.damage = damage;
    }

    public int getTime() {
        return time;
    }

    public String getId() {
        return id;
    }


    public int getDamage(){ return damage;};
}
