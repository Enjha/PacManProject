package pacman;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;
import gameplay.*;
import pacman.animations.GhostAnimation;
import scene.SceneElement;

/**
 * A thread of ghost playable
 */
public class ThreadGhostPlayable extends Thread implements ThreadEntity {

    /**
     * The entity ghost
     */
    private Ghost ghost;

    /**
     * The entity movement
     */
    private Movement movement;

    /**
     * the pause timer
     */
    private long time = 180;
    /**
     * The movement save if this movement is not possible
     */

    private Movement futureMovement;

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
    private boolean end = false;

    /**
     * The current game
     */
    private Game game;

    /**
     * The ghost animation
     */
    private GhostAnimation ghostAnimation;

    /**
     * The pause's state of this thread, by default its false
     */
    private volatile boolean pause = false;

    /**
     * <b>Constructor of ThreadGhostPlayable</b>
     * @param ghost
     *      a ghost
     * @param game
     *      a game
     */
    public ThreadGhostPlayable(Ghost ghost, Game game) {
        assert ghost != null : "Error : ghost null";
        assert game != null : "Error : game null";
        this.ghost = ghost;
        this.game = game;
        this.ghostAnimation = new GhostAnimation();
    }

    /**
     * Run the thread
     */
    public synchronized void run() {
        while (!end) {
            //ghost don't move
            if (ghost.getDirection() != Direction.Stop) {
                //There is a move register
                if (futureMovement != null) {
                    game.treatmentCollisionGame(futureMovement);
                    if (collision == null) {
                        //The move register is used and replace the current movement
                        movement = futureMovement;
                        futureMovement = null;
                        ghost.setDirection(movement.getDirection());
                        ghost.setAnimated(true);
                        ghostAnimation.movementAnimation(imageViewEntities);
                    }
                    else{
                        if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                            movement = futureMovement;
                            futureMovement = null;
                            ghost.setDirection(movement.getDirection());
                            ghost.setAnimated(true);
                            ghostAnimation.movementAnimation(imageViewEntities);
                        }
                        else{
                            //There is no movement register
                            game.treatmentCollisionGame(movement);
                            if(collision != null) {
                                //There is a collision with a fruit
                                if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                                    ghost.setDirection(movement.getDirection());
                                    ghost.setAnimated(true);
                                    ghostAnimation.movementAnimation(imageViewEntities);
                                }
                                //ghost can't move
                                if(collision.getSecondObjectCollision() instanceof SceneElement){
                                    movement = null;
                                    futureMovement = null;
                                }
                            }
                            else {
                                ghost.setDirection(movement.getDirection());
                                ghost.setAnimated(true);
                                ghostAnimation.movementAnimation(imageViewEntities);
                            }
                        }

                    }
                }
                else {
                    if (movement != null) {
                        game.treatmentCollisionGame(movement);
                        if (collision == null) {
                            ghost.setDirection(movement.getDirection());
                            ghost.setAnimated(true);
                            ghostAnimation.movementAnimation(imageViewEntities);
                        }
                        else{
                            if(collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit){
                                ghost.setDirection(movement.getDirection());
                                ghost.setAnimated(true);
                                ghostAnimation.movementAnimation(imageViewEntities);
                            }
                        }
                    }
                }
            }
            else {
                //ghost don't move and there is no move register
                if (futureMovement == null) {
                    movement = null;
                    try {
                        //ghost wait un move of the player
                        while (movement == null) {
                            wait();
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                else {
                    if (collision != null) {
                        ghost.setDirection(movement.getDirection());
                    }
                }
            }
            try {
                //The time before the next move
                if ( collision == null) {
                    wait(time);
                }
                else{
                    if(collision.getSecondObjectCollision() instanceof PacgumFruit || collision.getSecondObjectCollision() instanceof NormalFruit){
                        wait(time);
                    }
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
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
     * Modigy the movement of this entity or save a second move
     * @param movement
     *      a new movement
     */
    public synchronized void setMovement(Movement movement) {
        if (this.movement != null) {
            futureMovement = movement;

        } else {
            this.movement = movement;
            ghost.setDirection(movement.getDirection());
            notifyAll();
        }
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
           System.out.println(this.getName() + "/" +this.getState());
           notifyAll();
           System.out.println(this.getName() + "/" +this.getState());
       }
    }

    /**
     * we don't need to use the kernel engine
     * @param kernelEngine
     *      a new kernel engine
     */
    public void setKernelEngine(KernelEngine kernelEngine){}
}
