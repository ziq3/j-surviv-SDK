package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class WaterGun extends WeaponModel {
    public String name = "Sung_Nuoc";
    public String type = "Guns";
    public int size = 1;
    public int point = 1;
    public int damage = 10;
    public int obstacleDamage = 20;
    public int cooldown = 2;
    public int capacity = 20;
    public int bulletSpeed = 3;
    public int range = 4;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
