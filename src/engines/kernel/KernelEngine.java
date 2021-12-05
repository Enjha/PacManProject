package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.GraphicEngine;
import engines.graphic.ImageViewEntities;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Movement;
import javafx.scene.Scene;
import pacman.Life;
import pacman.Score;
import scene.SceneGame;

import java.util.List;

/**
 * The interface of a kernel engine
 */
public interface KernelEngine {

    /**
     * Connect a sound engine to the kernel engine
     * @param soundEngine
     *      a sound engine
     */
    void setSoundEngine(SoundEngine soundEngine);

    /**
     * Connect a physic engine to the kernel engine
     * @param physicEngine
     *      a physic engine
     */
    void setPhysicEngine(PhysicEngine physicEngine);

    /**
     * Connect a control engine to the kernel engine
     * @param controlEngine
     *      a control engine
     */
    void setControlEngine(ControlEngine controlEngine);

    /**
     * Connect a graphic engine to the kernel engine
     * @param graphicEngine
     *      a graphic engine
     */
    void setGraphicEngine(GraphicEngine graphicEngine);

    /**
     * Return all control of a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    List<Control> getControl(Entity entity);

    /**
     * Return the current sound's volume
     * @return a double value
     */
    double getVolume();

    /**
     * Modify the sounds's volume with a new volume
     * @param volume
     *      a new volume
     */
    void setVolume(double volume);

    /**
     * Return the current scene display
     * @return a object type of Scene
     */
    Scene getCurrentScene();

    /**
     * Return all entities
     * @return a list of object type of Entity
     */
    List<Entity> getEntities();

    /**
     * Return the entity with his name
     * @param entityName
     *       a entity's name
     * @return a object type of Entity
     */
    Entity getEntity(String entityName);

    /**
     * Modify a control's key with a new one
     * @param oldKey
     *      the control's old key
     * @param newKey
     *      the control's new key
     * @return a boolean value
     */
    boolean setControl(String oldKey,String newKey);

    /**
     * Mute all sound
     */
    void mute();

    /**
     * Unmut all sound
     */
    void unmute();

    /**
     * Return the current scene game
     * @return a object type of SceneGame
     */
    SceneGame getSceneGame();

    /**
     * Modify the control engine state with a new value
     * @param state
     *      a new control engine state value
     */
    void setControlEngineState(boolean state);

    /**
     * Modify the control engine scene with a new scene
     * @param scene
     *      a new scene
     */
    void setControlEngineScene(Scene scene);

    /**
     * Treat the collision with a movement
     * @param movement
     *      a new movement
     */
    void treatmentCollisionGame(Movement movement);

    /**
     * Update the scene game with a entity
     * @param entity
     *      a entity
     */
    void updateSceneGame(Entity entity);

    /**
     * Modify a entity's movement
     * @param movement
     *      a movement
     */
    void setMovementEntity(Movement movement);

    /**
     * Return a entity's image view entities
     * @param entity
     *      a entity
     * @return a object type of ImageViewEntities
     */
    ImageViewEntities getImageViewEntities(Entity entity);

    /**
     * Play a sound with his name with a cycle infinite
     * @param soundName
     *      a sound's name
     */
    void playSound(String soundName);

    /**
     * Play a sound with his name one time
     * @param soundName
     *      a sound's name
     */
    void playFirstSound(String soundName);

    /**
     * Stop a sound with his name
     * @param soundName
     *      a sound's name
     */
    void stopSound(String soundName);

    /**
     * Return all entities thread
     * @return a list of object type of Thread
     */
    List<Thread> getCurrentsThreads();

    /**
     * Return the score's information
     * @return a object type of Score
     */
    Score getScore();

    /**
     * Return the life's information
     * @return a object type of Life
     */
    Life getLife();
}
