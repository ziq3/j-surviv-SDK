package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class Broom extends WeaponModel {
    public String name = "Choi_Lau_Nha";
    public String type = "Melee";
    public int size = 1;
    public int point = 3;
    public int damage = 20;
    public int obstacleDamage = 25;
    public Double stunDuration = 0.9;
    public int knockbackDistance = 1;
    public int cooldown = 5;
    public int range = 2;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
