package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;

import java.util.Map;

public class ObstacleFactory {
    private static final Map<String, Obstacle> obstacleMap = Map.of(
            "CHEST", new Obstacle("CHEST", ElementType.CHEST ,20),
            "SPECIAL_CHEST", new Obstacle("SPECIAL_CHEST", ElementType.CHEST ,20),
            "GAS_TANK", new Obstacle("GAS_TANK", ElementType.TRAP,40),
            "FLOWER_VASE", new Obstacle("FLOWER_VASE", ElementType.TRAP,40),
            "FLOWER_VASE_FRAGMENT", new Obstacle("FLOWER_VASE_FRAGMENT", ElementType.TRAP,0),
            "INDESTRUCTIBLE_OBSTACLE", new Obstacle("INDESTRUCTIBLE_OBSTACLE", ElementType.INDESTRUCTIBLE_OBSTACLE)
            );

    public static Obstacle getObstacleById(String id){
        return obstacleMap.get(id);
    }

    public static Obstacle getObstacle(String id, int x, int y) throws CloneNotSupportedException {
        Obstacle obstacleBase = getObstacleById(id);

        Obstacle obstacle = (Obstacle) obstacleBase.clone();
        obstacle.setId(id);
        obstacle.setPosition(x,y);

        return obstacle;
    }

    public static Obstacle getObstacle(String id, int x, int y, int hp) throws CloneNotSupportedException {
        Obstacle obstacleBase = getObstacleById(id);
        Obstacle obstacle = new Obstacle(obstacleBase.getId(),obstacleBase.getType(),hp);
        obstacle.setPosition(x,y);

        return obstacle;
    }
}
