package jsclub.codefest2024.sdk.model;

import com.google.gson.annotations.SerializedName;

public class Player extends Element {
    @SerializedName("player_name")
    private String playerName;

    @SerializedName("bullet_num")
    private int bulletNum;

    @SerializedName("damage_reduction")
    private int damageReduction;

    private int point;
    private int hp;

    private ElementType type = ElementType.PLAYER;

    public Player() {}
}
