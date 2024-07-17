package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class TeddyBear extends WeaponModel {
    public String name = "Gau_Bong";
    public String type = "Throwables";
    public int size = 1;
    public int point = 2;
    public int damage = 10;
    public int obstacleDamage = 15;
    public Double stunDuration = 1.2;
    public int range = 5;
    public int explosionRadius = 3;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
