package jsclub.codefest2024.sdk.socket.data.Enemies;

import com.google.gson.Gson;

import jsclub.codefest2024.sdk.socket.Position;

public class Crow {
    public int damge = 10;
    public Position position;
    public String name = "CROW";

    public Crow(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
