package jsclub.codefest2024.socket.data.Weapons;

import com.google.gson.Gson;

public class Badminton extends WeaponModel {
    public String name = "Cau_Long";
    public String type = "Guns";
    public int size = 1;
    public int point = 1;
    public int damage = 5;
    public int obstacleDamage = 15;
    public int cooldown = 0;
    public int capacity = 5;
    public int bulletSpeed = 3;
    public int range = 4;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
