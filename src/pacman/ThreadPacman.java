package pacman;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;
import engines.sound.Sound;
import engines.sound.SoundManager;
import gameplay.*;
import pacman.animations.PacManAnimation;
import scene.SceneElement;

/**
 * A thread of Pac-Man
 */
public class ThreadPacman extends Thread implements ThreadEntity {

    /**
     * The entity Pac-Man
     */
    private Pacman pacman;

    /**
     * the pause timer
     */
    private final long time = 200;

    /**
     * The entity movement
     */
    private Movement movement;

    /**
     * The pause's state of this thread, by default its false
     */
    private boolean end = false;

    /**
     * The current game
     */
    private final Game game;

    /**
     * The movement save if this movement is not possible
     */
    private Movement futureMovement = null;

    /**
     * The entity collision after a movement, by default its null
     */
    private Collision collision = null;

    /**
     * The entity image view entities
     */
    private ImageViewEntities imageViewEntities;

    /**
     * The Pac-Man animation
     */
    private final PacManAnimation pacManAnimation;

    /**
     * The pause's state of this thread, by default its false
     */
    private volatile boolean pause = false;

    /**
     * <b>Constructor of ThreadPacman</b>
     * @param pacman
     *      a pacamn enity
     * @param game
     *      a game
     */
    public ThreadPacman(Pacman pacman, Game game) {
        assert pacman != null : "Error : pacman null";
        assert game != null : "Error : game null";

        this.pacman = pacman;
        this.game = game;
        this.pacManAnimation = new PacManAnimation();
    }

    /**
     * Run the thread
     */
    public synchronized void run() {
        while (!end) {
            //Pac-Man don't move
            if (pacman.getDirection() != Direction.Stop) {
                //There is a move register
                if (futureMovement != null) {
                    game.treatmentCollisionGame(futureMovement);
                    if (collision == null) {
                        //The move register is used and replace the current movement
                        movement = futureMovement;
                        futureMovement = null;
                        pacman.setDirection(movement.getDirection());
                        pacman.setAnimated(true);
                        pacManAnimation.movementAnimation(imageViewEntities);
                    }
                    //There is no movement register
                    else{
                        if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                            //The move register is used and replace the current movement
                            movement = futureMovement;
                            futureMovement = null;
                            pacman.setDirection(movement.getDirection());
                            pacman.setAnimated(true);
                            pacManAnimation.movementAnimation(imageViewEntities);
                            game.getImageViewEntity((Entity) collision.getSecondObjectCollision()).getImageView().setVisible(false);
                        }
                        else{
                            //There is a collision with the movement register
                            game.treatmentCollisionGame(movement);
                            if(collision != null) {
                                //There is a collision with a fruit
                                if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                                    pacman.setDirection(movement.getDirection());
                                    pacman.setAnimated(true);
                                    pacManAnimation.movementAnimation(imageViewEntities);
                                    game.getImageViewEntity((Entity) collision.getSecondObjectCollision()).getImageView().setVisible(false);
                                }
                                //There is a collision with a ghost
                                if (collision.getSecondObjectCollision() instanceof Ghost){
                                    pacManAnimation.deadAnimation(imageViewEntities);
                                }
                                //Pac-Man can't move
                                if(collision.getSecondObjectCollision() instanceof SceneElement){
                                    movement = null;
                                    futureMovement = null;
                                }
                            }
                            else {
                                pacman.setDirection(movement.getDirection());
                                pacman.setAnimated(true);
                                pacManAnimation.movementAnimation(imageViewEntities);
                            }
                        }

                    }
                }
                else {
                    if (movement != null) {
                        game.treatmentCollisionGame(movement);
                        if (collision == null) {
                            pacman.setDirection(movement.getDirection());
                            pacman.setAnimated(true);
                            pacManAnimation.movementAnimation(imageViewEntities);
                        }
                        else{
                            if(collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit){
                                pacman.setDirection(movement.getDirection());
                                pacman.setAnimated(true);
                                pacManAnimation.movementAnimation(imageViewEntities);
                                game.getImageViewEntity((Entity) collision.getSecondObjectCollision()).getImageView().setVisible(false);
                            }
                        }
                    }
                }
            }
             else {
                 //Pac-Man don't move and there is no move register
                if (futureMovement == null) {
                    movement = null;
                    try {
                        //Pac-Man wait un move of the player
                        while (movement == null) {
                            wait();
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                else {
                    if (collision != null) {
                        pacman.setDirection(movement.getDirection());
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
     * Modify the image view entities of this entity
     * @param imageViewEntities
     *      a new image view entities
     */
    public void setImageViewEntities(ImageViewEntities imageViewEntities) {
        pacman = (Pacman) imageViewEntities.getEntity();
        this.imageViewEntities = imageViewEntities;
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
            pacman.setDirection(movement.getDirection());
            notifyAll();
        }
    }

    /**
     * Return the entity of this thread
     * @return a object type of Entity
     */
    public Entity getEntity() {
        return pacman;
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
     * Modify the pause's state
     * @param pause
     *      a new state's pause
     */
    public synchronized void setPause(boolean pause){
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
