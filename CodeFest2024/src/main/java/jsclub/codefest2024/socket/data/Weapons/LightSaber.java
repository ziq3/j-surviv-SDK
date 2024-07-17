package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class LightSaber extends WeaponModel {
    public String name = "Kiem_Anh_Sang";
    public String type = "Melee";
    public int size = 1;
    public int point = 3;
    public int damage = 20;
    public int obstacleDamage = 15;
    public Double stunDuration = 0.6;
    public int knockbackDistance = 1;
    public int cooldown = 0;
    public int range = 2;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
