package jsclub.codefest2024.socket.data.Enemies;

import com.google.gson.Gson;

public class Chaser {
    public int Damage;
    public String Name;

    public Chaser(int Damge, String Name) {
        this.Damage = Damge;
        this.Name = Name;
    }

    public void setDamge(int Damage) {
        this.Damage = Damage;
    }

    public int getDamage() {
        return Damage;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
