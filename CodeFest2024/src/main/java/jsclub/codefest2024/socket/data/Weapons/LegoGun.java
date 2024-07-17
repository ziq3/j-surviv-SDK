package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class LegoGun extends WeaponModel {
    public String name = "Sung_Lego";
    public String type = "Guns";
    public int size = 1;
    public int point = 1;
    public int damage = 15;
    public int obstacleDamage = 10;
    public int cooldown = 1;
    public int capacity = 10;
    public int bulletSpeed = 3;
    public int range = 4;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
