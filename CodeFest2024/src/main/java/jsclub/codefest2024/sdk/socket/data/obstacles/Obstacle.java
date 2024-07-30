package jsclub.codefest2024.sdk.socket.data.obstacles;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.data.element.Element;

public class Obstacle  extends Element {
    private int endurance;

    public Obstacle(int endurance) {
        this.endurance = endurance;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
