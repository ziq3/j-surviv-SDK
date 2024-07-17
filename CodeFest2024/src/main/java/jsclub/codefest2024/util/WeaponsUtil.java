package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;
import jsclub.codefest2024.socket.data.Weapons.Weapons;
import com.google.gson.Gson;

public class WeaponsUtil {
    public static Map<String, Weapons> createWeaponsMap() {
        Map<String, Weapons> weaponList = new HashMap<>();

        weaponList.put("Súng nước", new Weapons("Guns", 1, 1, 10, 10, 20, null, 20, 2, 20, 3, 4, 0));
        weaponList.put("Súng Lego", new Weapons("Guns", 1, 1, 1, 15, 10, null, 15, 1, 10, 3, 4, 0));
        weaponList.put("Ná cao su", new Weapons("Guns", 1, 1, 1, 7, 10, null, 15, 1, 10, 3, 4, 0));
        weaponList.put("Cầu lông", new Weapons("Guns", 1, 1, 1, 5, 10, null, 15, 1, 5, 3, 4, 0));
        weaponList.put("Chổi quét nhà", new Weapons("Melee", 1, 1, 3, 20, 25, 0.9, 25, 1, 0, 0, 2, 0));
        weaponList.put("Dép lào", new Weapons("Melee", 1, 1, 3, 20, 25, 0.9, 25, 1, 0, 0, 2, 0));
        weaponList.put("Kiếm ánh sáng", new Weapons("Melee", 1, 1, 2, 15, 20, 0.6, 20, 1, 0, 0, 2, 0));
        weaponList.put("Tay không", new Weapons("Melee", 1, 1, 1, 5, 10, null, 10, 1, 0, 0, 1, 0));
        weaponList.put("Máy bay giấy", new Weapons("Throwables", 1, 1, 2, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("Bóng đá", new Weapons("Throwables", 1, 1, 2, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("Phi tiêu giấy", new Weapons("Throwables", 1, 1, 1, 10, 10, 1.0, 10, 1, 0, 0, 5, 3));
        weaponList.put("Gấu bông", new Weapons("Throwables", 1, 1, 1, 10, 15, 1.2, 15, 1, 0, 0, 5, 3));
        weaponList.put("Bóng nước", new Weapons("Throwables", 1, 1, 2, 10, 15, 0.6, 15, 1, 0, 0, 5, 3));

        return weaponList;
    }

    public Map<String, Weapons> WeaponList;

    public WeaponsUtil() {
        WeaponList = createWeaponsMap();
    }

    public String toString() {
        return new Gson().toJson(WeaponList);
    }

    public Weapons getWeapon(String name) {
        return WeaponList.get(name);
    }
}
