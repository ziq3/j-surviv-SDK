package jsclub.codefest2024.util;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

import jsclub.codefest2024.socket.data.Obstacles.Obstacle;

public class ObstacleUtil {
    public static Map<String, Obstacle> createObstaclesMap() {
        Map<String, Obstacle> ObstacleList = new HashMap<>();
        ObstacleList.put("Hop_vat_pham", new Obstacle(40, 2, 2, "Destructible"));
        ObstacleList.put("Hop_vat_pham_dac_biet", new Obstacle(40, 2, 2, "Destructible"));
        ObstacleList.put("Hoa_anh_tuc", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Bui_cay", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Da_to_hon", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Dai_phun_nuoc", new Obstacle(0, 36, 36, "Indestructible"));
        ObstacleList.put("Ghe_da_cong_vien", new Obstacle(0, 4, 1, "Indestructible"));
        ObstacleList.put("Thung_rac", new Obstacle(0, 2, 2, "Indestructible"));
        ObstacleList.put("Xe_may", new Obstacle(0, 4, 2, "Indestructible"));
        ObstacleList.put("Xe_ba_gac", new Obstacle(0, 4, 2, "Indestructible"));
        ObstacleList.put("Xe_day_ban_hang", new Obstacle(0, 4, 1, "Indestructible"));
        ObstacleList.put("Hoa_sen", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Binh_hoa", new Obstacle(10, 1, 1, "Destructible"));
        ObstacleList.put("Binh_xang", new Obstacle(100, 1, 1, "Destructible"));
        ObstacleList.put("Den_dien", new Obstacle(0, 2, 2, "Indestructible"));
        ObstacleList.put("Voi_nuoc", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Da_nho", new Obstacle(0, 1, 1, "Indestructible"));
        ObstacleList.put("Mai_nha", new Obstacle(0, 12, 12, "Indestructible"));
        ObstacleList.put("Tuong_dai", new Obstacle(0, 6, 6, "Indestructible"));
        ObstacleList.put("Bon_nuoc", new Obstacle(0, 8, 3, "Indestructible"));
        ObstacleList.put("Hon_non_bo", new Obstacle(0, 8, 8, "Indestructible"));
        ObstacleList.put("Manh_vo_cua_binh_hoa", new Obstacle(2, 1, 1, "Indestructible"));
        return ObstacleList;
    }

    public Map<String, Obstacle> ObstacleList;

    public ObstacleUtil() {
        ObstacleList = createObstaclesMap();
    }

    @Override
    public String toString() {
        return new Gson().toJson(ObstacleList);
    }

    public Obstacle getObstacle(String name) {
        return ObstacleList.get(name);
    }
}
