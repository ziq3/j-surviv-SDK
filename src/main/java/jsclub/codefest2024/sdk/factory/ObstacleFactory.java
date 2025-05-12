package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.ElementType;
import jsclub.codefest2024.sdk.model.obstacles.Obstacle;

import java.util.Map;

public class ObstacleFactory {
    /**
     * Available Obstacles
     */
    private static final Map<String, Obstacle> obstacleMap = Map.ofEntries(
        Map.entry("CHEST", new Obstacle("CHEST", ElementType.DESTRUCTIBLE_OBSTACLE ,20)),
        Map.entry("DRAGON_EGG", new Obstacle("DRAGON_EGG", ElementType.DESTRUCTIBLE_OBSTACLE ,50)),
        Map.entry("HUNT_TRAP", new Obstacle("HUNT_TRAP", ElementType.TRAP)),
        Map.entry("SPIKES", new Obstacle("SPIKES", ElementType.TRAP)),
        Map.entry("BANANA_PEEL", new Obstacle("BANANA_PEEL", ElementType.TRAP)),
        Map.entry("SMALL_STONE", new Obstacle("SMALL_STONE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("LARGE_STONE", new Obstacle("LARGE_STONE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("POND", new Obstacle("POND", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("TREE", new Obstacle("TREE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("WELL", new Obstacle("WELL", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("TREE_TRUNK", new Obstacle("TREE_TRUNK", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("DINASOUR_BONE", new Obstacle("DINASOUR_BONE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("BLACK_ROSE", new Obstacle("BLACK_ROSE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("WILD_ROSE", new Obstacle("WILD_ROSE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("BUSH", new Obstacle("BUSH", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("STATUE", new Obstacle("STATUE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("TORCH", new Obstacle("TORCH", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("ABANDONED_HOUSE", new Obstacle("ABANDONED_HOUSE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("RIVER", new Obstacle("RIVER", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("FLAG", new Obstacle("FLAG", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("SWORD_STAND", new Obstacle("SWORD_STAND", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("COAL_ORE", new Obstacle("COAL_ORE", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("GLOWING_FLOWER", new Obstacle("GLOWING_FLOWER", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("ABANDONED_CHEST", new Obstacle("ABANDONED_CHEST", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("MUSHROOM", new Obstacle("MUSHROOM", ElementType.INDESTRUCTIBLE_OBSTACLE)),
        Map.entry("RUINS", new Obstacle("RUINS", ElementType.INDESTRUCTIBLE_OBSTACLE))
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
