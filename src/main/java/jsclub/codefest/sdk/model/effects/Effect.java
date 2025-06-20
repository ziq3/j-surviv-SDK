package jsclub.codefest.sdk.model.effects;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Effect {
    @SerializedName("id")
    private String id;

    @SerializedName("duration")
    private Float duration;

    @SerializedName("level")
    private Integer level;

    public Effect() {
    }

    public Effect(Float duration, String id, Integer level) {
        this.duration = duration;
        this.id = id;
        this.level = level;
    }

    public Float getduration() {
        return duration;
    }

    public String getId() {
        return id;
    }

    public Integer getlevel(){ return level;};

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(Float duration) {
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
