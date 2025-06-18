package jsclub.codefest.sdk.model.players;

import com.google.gson.annotations.SerializedName;
import jsclub.codefest.sdk.model.Element;
import jsclub.codefest.sdk.model.ElementType;
import jsclub.codefest.sdk.model.Inventory;
import jsclub.codefest.sdk.model.effects.Effect;

import java.io.Serial;
import java.util.List;

public class Player extends Element {
//    @SerializedName("player_name")
//    private String playerName;
//
//    @SerializedName("bullet_num")
//    private int bulletNum;
//
//    @SerializedName("damage_reduction")
//    private int damageReduction;
//
//    @SerializedName("is_alive")
//    private boolean isAlive;

    @SerializedName("id")
    private String ID;

    private int health;
    private int score;
    private Inventory inventory;
    private List<String> canBeSeenBy;
    @SerializedName("effects")
    private List<Effect> effects;

//    private int point;
//    private int hp;

    public Player() {
        setType(ElementType.PLAYER);
    }

//    public String getPlayerName() {
//        return playerName;
//    }
//
//    public int getBulletNum() {
//        return bulletNum;
//    }
//
//    public int getDamageReduction() {
//        return damageReduction;
//    }

//    public int getPoint() {
//        return point;
//    }
//
//    public int getHp() {
//        return hp;
//    }

//    public boolean getIsAlive() {
//        return isAlive;
//    }

    public String getID() {
        return ID;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<String> getCanBeSeenBy() {
        return canBeSeenBy;
    }

    public List<Effect> getEffects() {
        return effects;
    }
}
