package pacman;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;
import gameplay.*;
import pacman.animations.GhostAnimation;
import scene.SceneElement;

/**
 * A thread of a ghost control by a IA
 */
public class ThreadGhostIA extends Thread implements ThreadEntity {

    /**
     * The ghost entity
     */
    private final Ghost ghost;

    /**
     * The current game
     */
    private final Game game;

    /**
     * The entity movement
     */
    private Movement movement;

    /**
     * The entity collision after a movement, by default its null
     */
    private Collision collision = null;

    /**
     * The entity image view entities
     */
    private ImageViewEntities imageViewEntities;

    /**
     * The pause's state of this thread, by default its false
     */
    private boolean pause = false;

    /**
     * The timer of wait
     */
    private final long time = 180;

    /**
     * The ghost animation
     */
    private final GhostAnimation ghostAnimation;

    /**
     * The end of the thread, by default its false
     */
    private boolean end = false;

    /**
     * The kernel engine
     */
    private KernelEngine kernelEngine;

    /**
     * <b>Constructor of ThreadGhostIA</b>
     * @param ghost
     *      a ghost
     * @param game
     *      a game
     */
    public ThreadGhostIA(Ghost ghost, Game game){
        assert game != null : "Error : game null";
        assert ghost != null : "Error : ghost null";
        this.ghost = ghost;
        this.game = game;
        ghostAnimation = new GhostAnimation();
    }

    /**
     * Run the thread
     */
    public void run(){
        assert kernelEngine != null : "Error : kernel engine null";
        while(!end){
            setMovement(kernelEngine.getMovementIA(ghost));
            game.treatmentCollisionGame(movement);
            if(collision == null){
                ghostAnimation.movementAnimation(imageViewEntities);
            }
            else {
                if(collision.getSecondObjectCollision() instanceof SceneElement){
                    movement = null;
                    ghost.setDirection(Direction.Stop);
                }
            }
        }
    }

    /**
     * Return the entity of this thread
     * @return a object type of Entity
     */
    public Entity getEntity() {
        return ghost;
    }

    /**
     * Modigy the movement of this entity
     * @param movement
     *      a new movement
     */
    public void setMovement(Movement movement) {
        assert movement != null : "Error : movement null";
        ghost.setDirection(movement.getDirection());
        this.movement = movement;
    }

    /**
     * Modify the collision
     * @param collision
     *      a new collision
     */
    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    /**
     * Modify the image view entities of this entity
     * @param imageViewEntities
     *      a new image view entities
     */
    public void setImageViewEntities(ImageViewEntities imageViewEntities) {
        assert imageViewEntities != null : "Error : image view entities null";
        this.imageViewEntities = imageViewEntities;
    }

    /**
     * Modify the pause's state
     * @param pause
     *      a new state's pause
     */
    public synchronized void setPause(boolean pause) {
        this.pause = pause;
        if(!pause){
            notifyAll();
        }
    }

    /**
     * Modify the kernel engine
     * @param kernelEngine
     *      a new kernel engine
     */
    public void setKernelEngine(KernelEngine kernelEngine){
        assert kernelEngine != null : "Error : kernel engine null";
        this.kernelEngine = kernelEngine;
    }
}
