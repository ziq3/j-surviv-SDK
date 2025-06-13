package jsclub.codefest2024.sdk.model.effects;

import com.google.gson.annotations.SerializedName;

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

    public Integer getduration() {
        return duration;
    }

    public String getId() {
        return id;
    }


    public Integer getlevel(){ return level;};
}
