package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class Hand extends WeaponModel {
    public String name = "Choi_Lau_Nha";
    public String type = "Melee";
    public int size = 1;
    public int point = 0;
    public int damage = 5;
    public int obstacleDamage = 0;
    public Double stunDuration = 0.0;
    public int knockbackDistance = 0;
    public int cooldown = 1;
    public int range = 1;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
