package jsclub.codefest2024.sdk.socket.data.equipments;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.data.element.Element;

public class HealingItem extends Element {
    private int healingHp;
    private int usageTime;
    private int point;

    // Constructor
    public HealingItem(int healingHp, int usageTime, int point) {
        this.healingHp = healingHp;
        this.usageTime = usageTime;
        this.point = point;
    }


    public void setHealingHp(int healingHp) {
        this.healingHp = healingHp;
    }

    public void setUsageTime(int usageTime) {
        this.usageTime = usageTime;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getHealingHp() {
        return healingHp;
    }

    public int getUsageTime() {
        return usageTime;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
