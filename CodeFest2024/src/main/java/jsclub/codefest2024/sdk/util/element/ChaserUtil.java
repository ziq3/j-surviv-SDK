package jsclub.codefest2024.sdk.util.element;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.sdk.socket.data.Enemies.Chaser;

public class ChaserUtil {
    public static Map<String, Chaser> createChasersMap() {
        Map<String, Chaser> chaserList = new HashMap<>();
        chaserList.put("Chaser1", new Chaser(15));
        chaserList.put("Chaser2", new Chaser(15));
        chaserList.put("Chaser3", new Chaser(15));
        chaserList.put("Chaser4", new Chaser(15));
        return chaserList;
    }

    public Map<String, Chaser> chaserList;

    public ChaserUtil() {
        this.chaserList = createChasersMap();
    }

    public String toString() {
        return new Gson().toJson(chaserList);
    }

    public Chaser getChaser(String name) {
        return chaserList.get(name);
    }
}
