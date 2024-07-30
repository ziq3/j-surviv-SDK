package jsclub.codefest2024.sdk.socket.data.enemies;

import com.google.gson.Gson;

import jsclub.codefest2024.sdk.socket.Position;
import jsclub.codefest2024.sdk.socket.data.element.Element;

public class Crow extends Element {
    public int damge = 10;
    public Position position;
    public String name = "CROW";

    public Crow(int damge){
        this.damge = damge;
    }

    public Crow(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
