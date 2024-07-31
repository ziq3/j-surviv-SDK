package jsclub.codefest2024.sdk.socket.data.equipments;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.data.Element;

public class Armor extends Element {
    private Double damageReduce;
    private int rare;
    private int point;

    // Constructor
    public Armor(Double damageReduce, int rare, int point) {
        this.damageReduce = damageReduce;
        this.rare = rare;
        this.point = point;
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
