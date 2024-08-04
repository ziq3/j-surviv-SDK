package jsclub.codefest2024.sdk.model.players;

import com.google.gson.annotations.SerializedName;
import jsclub.codefest2024.sdk.model.Element;
import jsclub.codefest2024.sdk.model.ElementType;

public class Player extends Element {
    @SerializedName("player_name")
    private String playerName;

    @SerializedName("bullet_num")
    private int bulletNum;

    @SerializedName("damage_reduction")
    private int damageReduction;

    private int point;
    private int hp;

    public Player() {
        setType(ElementType.PLAYER);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBulletNum() {
        return bulletNum;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public int getPoint() {
        return point;
    }

    public int getHp() {
        return hp;
    }
}
