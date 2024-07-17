package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class Sandal extends WeaponModel {
    public String name = "Dep_Lao";
    public String type = "Melee";
    public int size = 1;
    public int point = 3;
    public int damage = 20;
    public int obstacleDamage = 0;
    public Double stunDuration = 0.9;
    public int knockbackDistance = 2;
    public int cooldown = 6;
    public int range = 1;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
