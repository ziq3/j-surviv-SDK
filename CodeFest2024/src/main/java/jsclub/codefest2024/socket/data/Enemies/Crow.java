package jsclub.codefest2024.socket.data.Enemies;

import com.google.gson.Gson;

public class Crow {
    public int Damge = 10;
    public String name = "CROW";

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
