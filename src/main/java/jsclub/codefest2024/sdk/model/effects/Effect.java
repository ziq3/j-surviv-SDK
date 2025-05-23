package jsclub.codefest2024.sdk.model.effects;

import com.google.gson.annotations.SerializedName;

public class Effect {
    @SerializedName("id")
    private String id;

    @SerializedName("time")
    private String time;

    public Effect() {
    }

    public String getTime() {
        return time;
    }

    public String getId() {
        return id;
    }
}
