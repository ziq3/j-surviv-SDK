package jsclub.codefest2024.sdk.socket.data.Enemies;

import com.google.gson.Gson;

public class DarkArea {
    public int damage = 5;
    public String name = "DARK_AREA";

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
