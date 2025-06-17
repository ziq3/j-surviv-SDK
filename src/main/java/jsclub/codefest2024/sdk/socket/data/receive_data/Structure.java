package jsclub.codefest2024.sdk.socket.data.receive_data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Structure {
    @SerializedName("xTopLeft")
    public int xTopLeft;
    
    @SerializedName("yTopLeft")
    public int yTopLeft;

    @SerializedName("xBottomRight")
    public int xBottomRight;

    @SerializedName("yBottomRight")
    public int yBottomRight;

    @SerializedName("id")
    public String id;

    @SerializedName("attributes")
    public List<Object> attributes;

    

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
