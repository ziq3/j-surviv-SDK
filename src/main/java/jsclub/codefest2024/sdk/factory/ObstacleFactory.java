package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;
import jsclub.codefest2024.sdk.model.obstacles.ObstacleTag;

import java.util.Map;

public class ObstacleFactory {
    /**
     * Available Obstacles
     */
    private static final Map<String, Obstacle> obstacleMap = Map.ofEntries(
        Map.entry("CHEST", new Obstacle("CHEST", ElementType.OBSTACLE, ObstacleTag.DESTRUCTIBLE ,20)),
        Map.entry("DRAGON_EGG", new Obstacle("DRAGON_EGG", ElementType.OBSTACLE, ObstacleTag.DESTRUCTIBLE ,50)),
        Map.entry("HUNT_TRAP", new Obstacle("HUNT_TRAP", ElementType.OBSTACLE, ObstacleTag.TRAP, 0)),
        Map.entry("SPIKES", new Obstacle("SPIKES", ElementType.OBSTACLE, ObstacleTag.TRAP, 0)),
        Map.entry("BANANA_PEEL", new Obstacle("BANANA_PEEL", ElementType.OBSTACLE, ObstacleTag.TRAP , 0)),
        Map.entry("INDESTRUCTIBLE", new Obstacle("INDESTRUCTIBLE", ElementType.OBSTACLE, ObstacleTag.INDESTRUCTIBLE , 0)),
        Map.entry("POND", new Obstacle("POND", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("STONE_DOOR", new Obstacle("STONE_DOOR", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("BUSH", new Obstacle("BUSH", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("ABANDONED_HOUSE", new Obstacle("ABANDONED_HOUSE", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("PORTAL", new Obstacle("PORTAL", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("ABANDONED_RUINS", new Obstacle("ABANDONED_RUINS", ElementType.OBSTACLE, ObstacleTag.CAN_GO_THROUGH)),      
        Map.entry("RIVER", new Obstacle("RIVER", ElementType.OBSTACLE, ObstacleTag.CAN_SHOOT_THROUGH))      
    );

    /**
     * Find obstacle by id.
     *
     * @param id String to find obstacle.
     * @return Obstacle mapped with id.
     */
    public static Obstacle getObstacleById(String id){
        return obstacleMap.get(id);
    }

    /**
     * use for setting indestructible obstacles
     * Find obstacle by id.
     * Set position for obstacle
     *
     * @param id String to find obstacle.
     * @param x,y int to set position.
     * @return Obstacle with updated position,id.
     * @throws CloneNotSupportedException If clone is not supported.
     */
    public static Obstacle getObstacle(String id, int x, int y) throws CloneNotSupportedException {
        Obstacle obstacleBase = getObstacleById(id);

        Obstacle obstacle = (Obstacle) obstacleBase.clone();
        obstacle.setId(id);
        obstacle.setPosition(x,y);

        return obstacle;
    }

    /**
     * use for setting destructible obstacles
     * Find obstacle by id.
     * Set position for obstacle
     *
     * @param id String to find obstacle.
     * @param x,y int to set position.
     * @param hp int to set healing point.
     * @return Obstacle with updated position,hp,id.
     * @throws CloneNotSupportedException If clone is not supported.
     */
    public static Obstacle getObstacle(String id, int x, int y, int hp) throws CloneNotSupportedException {
        Obstacle obstacleBase = getObstacleById(id);
        Obstacle obstacle = (Obstacle) obstacleBase.clone();

        obstacle.setHp(hp);
        obstacle.setId(id);
        obstacle.setPosition(x,y);

        return obstacle;
    }
}
