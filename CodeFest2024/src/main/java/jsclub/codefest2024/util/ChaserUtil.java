package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.socket.data.Enemies.Chaser;

public class ChaserUtil {
    public static Map<String, Chaser> createChasersMap() {
        Map<String, Chaser> ChaserList = new HashMap<>();
        ChaserList.put("Chaser1", new Chaser(15, "Chaser1"));
        ChaserList.put("Chaser2", new Chaser(15, "Chaser2"));
        ChaserList.put("Chaser3", new Chaser(15, "Chaser3"));
        ChaserList.put("Chaser4", new Chaser(15, "Chaser4"));
        return ChaserList;
    }

    public Map<String, Chaser> ChaserList;

    public ChaserUtil() {
        ChaserList = createChasersMap();
    }

    public String toString() {
        return new Gson().toJson(ChaserList);
    }

    public Chaser getChaser(String name) {
        return ChaserList.get(name);
    }
}
