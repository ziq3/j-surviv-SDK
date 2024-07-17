package jsclub.codefest2024.socket.data.Equipments;

import com.google.gson.Gson;

public class HealingItem {
    private int healingHp;
    private int size;
    private int usageTime;
    private int rare;
    private int point;

    // Constructor
    public HealingItem(int healingHp, int size, int usageTime, int point, int rare) {
        this.healingHp = healingHp;
        this.size = size;
        this.usageTime = usageTime;
        this.point = point;
        this.rare = rare;
    }

    public void setHealingHp(int healingHp) {
        this.healingHp = healingHp;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setUsageTime(int usageTime) {
        this.usageTime = usageTime;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getHealingHp() {
        return healingHp;
    }

    public int getSize() {
        return size;
    }

    public int getUsageTime() {
        return usageTime;
    }

    public int getPoint() {
        return point;
    }

    public int getRare() {
        return rare;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
