package engines.kernel;

import engines.IA.IAEngine;
import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.GraphicEngine;
import engines.graphic.ImageViewEntities;
import engines.physic.Collision;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Game;
import gameplay.Movement;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import pacman.Ghost;
import pacman.Life;
import pacman.Score;
import scene.SceneGame;

import java.util.List;

/**
 * A classic kernel engine
 */
public class ClassicKernelEngine implements KernelEngine {

    /**
     * The graphic engine connect to this kernel engine
     */
    private GraphicEngine graphicEngine;

    /**
     * The sound engine connect to this kernel engine
     */
    private SoundEngine soundEngine;

    /**
     * The physic engine connect to this kernel engine
     */
    private PhysicEngine physicEngine;

    /**
     * The control engine connect to this kernel engine
     */
    private ControlEngine controlEngine;

    private IAEngine iaEngine;

    /**
     * The current game
     */
    private Game game;

    /**
     * <b>Constructor of ClassicKernelEngine</b>
     * @param game
     *      a game
     */
    public ClassicKernelEngine(Game game) {
        assert game != null : "Error : game null";
        this.game = game;
    }

    /**
     * Return a control with his key name
     * @param keyName
     *      a control's key name
     * @return a object type of Control
     */
    public Control getControl(String keyName) {
        assert keyName != null : "Error : key name null";
        assert controlEngine != null : "Error : control engine null";
        return controlEngine.getControl(keyName);
    }

    /**
     * Return the sound's volume of the sound engine
     * @return a double value
     */
    public double getVolume() {
        assert soundEngine != null : "Error : sound engine null";
        return soundEngine.getVolume();
    }

    /**
     * Modify the sound's volume with a new volume
     * @param volume
     *      a new volume
     */
    public void setVolume(double volume) {
        assert volume >= 0 : "Error : volume < 0";
        assert soundEngine != null : "Error : sound engine null";
        soundEngine.changeVolumeAll(volume);
    }

    /**
     * Connect a soud engine to this kernel engine
     * @param soundEngine
     *      a sound engine
     */
    public void setSoundEngine(SoundEngine soundEngine) {
        assert soundEngine != null : "Error : sound engine null";
        this.soundEngine = soundEngine;
    }

    /**
     * Connect a physic engine to this kernel engine
     * @param physicEngine
     *      a physic engine
     */
    public void setPhysicEngine(PhysicEngine physicEngine) {
        assert physicEngine != null : "Error : physic engine null";
        this.physicEngine = physicEngine;
    }

    /**
     * Connect a control engine to this kernel engine
     * @param controlEngine
     *      a control engine
     */
    public void setControlEngine(ControlEngine controlEngine) {
        assert controlEngine != null : "Error : control engine null";
        this.controlEngine = controlEngine;
    }

    /**
     * Connect a graphic engine to this kernel engine
     * @param graphicEngine
     *      a graphic engine
     */
    public void setGraphicEngine(GraphicEngine graphicEngine) {
        assert graphicEngine != null : "Error : graphic engine null";
        this.graphicEngine = graphicEngine;
    }

    public void setIaEngine(IAEngine iaEngine){
        this.iaEngine = iaEngine;
    }

    /**
     * Return the current scene display
     * @return a object type of Scene
     */
    public Scene getCurrentScene() {
        assert graphicEngine != null : "Error : graphic engine null";
        return graphicEngine.getCurrentScene();
    }

    /**
     * Return all control of a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    public List<Control> getControl(Entity entity) {
        assert controlEngine != null : "Error : control engine null";
        assert entity != null : "Error : entity null";
        return controlEngine.getControl(entity);
    }

    /**
     * Return all entity
     * @return a list of object type of Entity
     */
    public List<Entity> getEntities() {
        assert game != null : "Error : game null";
        return game.getEntities();
    }

    /**
     * Modify a control's key with a new one
     * @param oldKey
     *      the control's old key
     * @param newKey
     *      the control's new key
     * @return a boolean value
     */
    public boolean setControl(String oldKey, String newKey) {
        assert controlEngine != null : "Error : control engine null";
        assert oldKey != null : "Error : old key null";
        assert newKey != null : "Error : new key null";
        return controlEngine.setKey(oldKey, newKey);
    }

    /**
     * Mute all sound of the sound engine
     */
    public void mute() {
        assert soundEngine != null : "Error : sound engine null";
        soundEngine.mute();
    }

    /**
     * Unmute all sound of the sound engine
     */
    public void unmute() {
        assert soundEngine != null : "Error : sound engine null";
        soundEngine.unmute();
    }

    /**
     * Return the current scene game
     * @return a object type of SceneGame
     */
    public SceneGame getSceneGame() {
        assert game != null : "Error : game != null";
        return game.getSceneGame();
    }

    /**
     * Modify the control engine state with a new one
     * @param state
     *      a new control engine state
     */
    public void setControlEngineState(boolean state) {
        assert controlEngine != null : "Error : control engine null";
        controlEngine.setEngineState(state);
    }

    /**
     * Modify the control engine scene with a new one
     * @param scene
     *      a new scene
     */
    public void setControlEngineScene(Scene scene) {
        assert controlEngine != null : "Error : control engine null";
        assert scene != null : "Error : scene null";
        controlEngine.setScene(scene);
    }

    /**
     * Treat the collisions with a movement
     * @param movement
     *      a new movement
     */
    public void treatmentCollisionGame(Movement movement) {
        assert physicEngine != null : "Error : physic engine null";
        assert movement != null : "Error : movement null";
        assert game != null : "Error : game null";

        //System.out.println("Class ClassicKernelEngine --> treatmentCollisionGame : Traitement de la collision");
            Collision collision = physicEngine.moveEntity(movement, game.getSceneGame());
            game.treatmentCollision(movement, collision);
    }

    /**
     * Modify the movement of a entity with a new one
     * @param movement
     *      a new movement
     */
    public void setMovementEntity(Movement movement) {
        assert game != null : "Error : game null";
        assert movement != null : "Error : movement null";

        if (movement.getEntity().isCharacter()) {
            game.getThreadEntity(movement.getEntity()).setMovement(movement);
            game.startThreadEntity();
        }
    }

    /**
     * Return the image view entities of a entity
     * @param entity
     *      a entity
     * @return a object type of ImageViewEntities
     */
    public ImageViewEntities getImageViewEntities(Entity entity) {
        assert graphicEngine != null : "Error : graphic engine null";
        assert entity != null : "Error : entity null";
        return graphicEngine.getImageViewEntities(entity);
    }

    /**
     * Return a entity with his name or null if this entity don't exist
     * @param entityName
     *       a entity's name
     * @return a object type of Entity
     */
    public Entity getEntity(String entityName) {
        assert game != null : "Error : game null";
        assert entityName != null : "Error entity name null";

        if(game.getEntities().size() != 0){
            for (Entity entity : game.getEntities()) {
                if (entity.getEntityName().equals(entityName)) {
                    return entity;
                }
            }
        }
        return null;
    }

    /**
     * Update the scene game with a entity
     * @param entity
     *      a entity
     */
    public void updateSceneGame(Entity entity) {
        assert graphicEngine != null : "Error : graphic engine null";
        assert entity != null : "Error : entity null";
        graphicEngine.updateSceneGame(entity);
    }

    /**
     * Play a sound with his name during a cycle infinite
     * @param soundName
     *      a sound's name
     */
    public void playSound(String soundName) {
        assert soundName != null : "Error : sound name null";
        assert soundEngine != null : "Error : sound engine null";
        soundEngine.playSound(soundName, MediaPlayer.INDEFINITE);
    }

    /**
     * Play a sound with his name one time
     * @param soundName
     *      a sound's name
     */
    public void playFirstSound(String soundName) {
        assert soundEngine != null : "Error : sound engine null";
        soundEngine.playSound(soundName, 1);
    }

    /**
     * Stop a sound with his name
     * @param soundName
     *      a sound's name
     */
    public void stopSound(String soundName){
        assert soundEngine != null : "Error : soud engine null";
        soundEngine.stopSound(soundName);
    }

    /**
     * Return all entities thread
     * @return a list of object type of Thread
     */
    public List<Thread> getCurrentsThreads() {
        assert game != null : "Error : game null";
        return game.getThreadEntities();
    }

    /**
     * Return the score's information
     * @return a object type of Score
     */
    public Score getScore() {
        assert game != null : "Error : game null";
        return game.getScore();
    }

    /**
     * Return the life's information
     * @return a object type of life
     */
    public Life getLife() {
        assert game != null : "Error : game null";
        return game.getLife();
    }

    /**
     * Return the movement for a entity control by a IA
     * @param entity
     *      a entity
     * @return a object type of Movement
     */
    public Movement getMovementIA(Entity entity){
        assert entity != null : "Error : entity null";
        return iaEngine.generateRandomMovement(entity);
    }

    /**
     * Create all thread entities
     */
    public void createThreadEntities(){
        game.createThreadEntity();
    }

    /**
     * return the game mode solo state
     * @return a boolean value
     */
    public boolean getSolo(){
        return graphicEngine.getSolo();
    }
}
