package jsclub.codefest2024.socket.data.Equipments;

import com.google.gson.Gson;

public class Armor {
    private int size;
    private Double damageReduce;
    private int rare;
    private int point;

    // Constructor
    public Armor(int size, Double damageReduce, int rare, int point) {
        this.size = size;
        this.damageReduce = damageReduce;
        this.rare = rare;
        this.point = point;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDamageReduce(Double damageReduce) {
        this.damageReduce = damageReduce;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSize() {
        return size;
    }

    public Double getDamageReduce() {
        return damageReduce;
    }

    public int getRare() {
        return rare;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
