package jsclub.codefest.sdk.model.effects;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Effect {
    @SerializedName("id")
    private String id;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("level")
    private Integer level;

    public Effect() {
    }

    public Effect(Integer duration, String id, Integer level) {
        this.duration = duration;
        this.id = id;
        this.level = level;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }

    public Integer getLevel(){ return level;};

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
