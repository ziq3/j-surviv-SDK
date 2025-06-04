package jsclub.codefest2024.sdk.socket.data.receive_data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import jsclub.codefest2024.sdk.model.ElementType;

import java.util.List;

public class Entity {
    @SerializedName("x")
    public int x;

    @SerializedName("x")
    public int y;

    @SerializedName("id")
    public String id;

    @SerializedName("type")
    public ElementType type;

    @SerializedName("attributes")
    public List<Object> attributes;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
