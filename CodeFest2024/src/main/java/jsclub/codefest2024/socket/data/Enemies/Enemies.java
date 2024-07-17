package jsclub.codefest2024.socket.data.Enemies;

import com.google.gson.Gson;

public class Enemies {
    public DarkArea darkArea;
    public Crow crow;
    public Chaser chaserList;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
