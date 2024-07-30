package jsclub.codefest2024.socket.data.Obstacles;

import com.google.gson.Gson;

public class Obstacle {
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
