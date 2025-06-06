package jsclub.codefest2024.sdk.socket.data.receive_data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jsclub.codefest2024.sdk.model.ElementType;

public class ItemData {
    @SerializedName("id")
    public String ID;

    @SerializedName("type")
    public ElementType type;

    @SerializedName("level")
    public int level;

    @SerializedName("durability")
    public int durability;

    @SerializedName("attributes")
    public Object attributes;

    public ElementType getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
