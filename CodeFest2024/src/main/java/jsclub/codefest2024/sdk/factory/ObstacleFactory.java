package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;

import java.util.Map;

public class ObstacleFactory {
    private static final Map<String, Obstacle> obstacleMap = Map.of(
            "DESTRUCTIBLE", new Obstacle("DESTRUCTIBLE", ElementType.DESTRUCTIBLE_OBSTACLE ,100),
            "INDESTRUCTIBLE", new Obstacle("INDESTRUCTIBLE", ElementType.INDESTRUCTIBLE_OBSTACLE),
            "TRAP", new Obstacle("TRAP", ElementType.TRAP,100)
    );

    public static Obstacle getObstacleById(String id){
        return obstacleMap.get(id);
    }

    public static int getObStacleHp(String id){
        Obstacle obstacle = getObstacleById(id);

        return obstacle.getHp();
    }

}
