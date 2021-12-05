package pacman.scene;

import gameplay.Entity;
import gameplay.Game;
import scene.SceneGame;

import java.util.List;

/**
 * The interface of a labyrinth generator
 */
public interface LabyrinthGenerator {

    /**
     * Generate the labyrinth in the scene game
     * @return a object type of SceneGame
     */
    SceneGame generateLabyrinth();

    /**
     * Generate all entities
     * @param sceneGame
     *      a scene game
     * @param game
     *      a game
     * @return a list of object type of Entity
     */
    List<Entity> generateEntity(SceneGame sceneGame, Game game);
}
