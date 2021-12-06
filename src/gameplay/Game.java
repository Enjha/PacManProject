package gameplay;

import engines.graphic.ImageViewEntities;
import engines.physic.Collision;
import javafx.stage.Stage;
import pacman.Life;
import pacman.Score;
import scene.SceneGame;

import java.awt.*;
import java.util.List;

/**
 * The interface of a game
 */
public interface Game {

    /**
     * Create all entity needed for the fame
     */
    void createEntity();

    /**
     * Return all entity of the game
     * @return a list of object type of Entity
     */
    List<Entity> getEntities();

    /**
     * Return the scene game
     * @return a object type of SceneGame
     */
    SceneGame getSceneGame();

    /**
     * Create the scene game of the game
     */
    void generateSceneGame();

    /**
     * Start all engine needed for the game
     * @param stage
     *      the stage of this application
     */
    void startEngine(Stage stage);

    /**
     * Treeat the collision of a entity with a movement
     * @param movement
     *      the entity's movement
     * @param collision
     *      the collision corresponding at this movement
     */
    void treatmentCollision(Movement movement,Collision collision);

    /**
     * Return all entity's thread
     * @return a list of object type of Thread
     */
    List<Thread> getThreadEntities();

    /**
     * Start all entity's thread
     */
    void startThreadEntity();

    /**
     * Return the entity's thread of a entity
     * @param entity
     *      a entity
     * @return a object type of ThreadEntity
     */
    ThreadEntity getThreadEntity(Entity entity);

    /**
     * Update the scene game whit a entity's movement
     * @param movement
     *      a entity's movement
     */
    void updateSceneGame(Movement movement);

    /**
     * Call the collision's treatment
     * @param movement
     *      a entity's movement
     */
    void treatmentCollisionGame(Movement movement);

    /**
     * Return the image view entities of a entity
     * @param entity
     *      a entity
     * @return a object type of ImageViewEntities
     */
    ImageViewEntities getImageViewEntity(Entity entity);

    /**
     * Return the score's infomration
     * @return a object type of Score
     */
    Score getScore();

    /**
     * Return the life's information
     * @return a object type of Life
     */
    Life getLife();

    /**
     * Return the team manager of the game
     * @return a object type of TeamManager
     */
    TeamManager getTeamManager();

    void createThreadEntity();
}
