package jsclub.codefest2024.socket.data.Enemies;

import com.google.gson.Gson;

public class DarkArea {
    public int Damage = 5;
    public String name = "DARK_AREA";

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
