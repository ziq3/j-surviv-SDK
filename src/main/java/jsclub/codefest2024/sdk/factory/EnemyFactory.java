package jsclub.codefest2024.sdk.factory;

import jsclub.codefest2024.sdk.model.enemies.Enemy;

import java.util.Map;

public class EnemyFactory {
    private static final Map<String, Enemy> enemyMap = Map.of(
//        "CROW", new Enemy("CROW", 10),
//        "PARENT", new Enemy("PARENT", 15),
//        "NINJA_LEAD", new Enemy("NINJA_LEAD", 15),
//        "DOG", new Enemy("DOG", 15),
//        "GRANDPA", new Enemy("GRANDPA", 15)
        "ENEMY", new Enemy("ENEMY", 15),
    "FLOWER_VASE_FRAGMENT", new Enemy("FLOWER_VASE_FRAGMENT", 2)
    );

    public static Enemy getEnemyById(String id) {
        return enemyMap.get(id);
    }

    public static Enemy getEnemy(String id, int x, int y) throws CloneNotSupportedException {
        Enemy enemyBase = getEnemyById(id);

        Enemy enemy = (Enemy) enemyBase.clone();
        enemy.setPosition(x, y);
        enemy.setId(id);

        return enemy;
    }
}