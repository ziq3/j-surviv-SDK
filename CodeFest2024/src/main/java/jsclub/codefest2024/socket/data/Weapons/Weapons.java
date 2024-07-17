package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class Weapons {
    public WaterGun waterGun;
    public LegoGun legoGun;
    public RubberGun rubberGun;
    public Badminton badminton;
    public Broom broom;
    public Sandal sandal;
    public LightSaber lightSaber;
    public Hand hand;
    public PaperAirplane paperAirplane;
    public Ball ball;
    public PaperDart paperDart;
    public TeddyBear teddyBear;
    public WaterBall waterBall;

    public Gravel gravel;
    public Lego lego;
    public Water water;
    public BadmintonBall badmintonBall;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
