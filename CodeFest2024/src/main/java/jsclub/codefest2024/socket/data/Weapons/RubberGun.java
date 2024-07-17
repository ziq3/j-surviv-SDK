package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class RubberGun extends WeaponModel {
    public String name = "Na_Cao_Su";
    public String type = "Guns";
    public int size = 1;
    public int point = 1;
    public int damage = 7;
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
