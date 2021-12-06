package pacman;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;
import gameplay.*;
import pacman.animations.GhostAnimation;
import pacman.Ghost;
import scene.SceneElement;

public class ThreadGhostPlayable extends Thread implements ThreadEntity {

    private Ghost ghost;
    private Movement movement;
    private long time = 180;
    private Movement futureMovement;
    private Collision collision = null;
    private ImageViewEntities imageViewEntities;
    private boolean end = false;
    private Game game;
    private GhostAnimation ghostAnimation;
    private volatile boolean pause = false;

    public ThreadGhostPlayable(Ghost ghost, Game game) {
        this.ghost = ghost;
        this.game = game;
        this.ghostAnimation = new GhostAnimation();
    }

    public synchronized void run() {
        while (!end) {
            if (ghost.getDirection() != Direction.Stop) {
                if (futureMovement != null) {
                    game.treatmentCollisionGame(futureMovement);
                    if (collision == null) {
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
                            game.treatmentCollisionGame(movement);
                            if(collision != null) {
                                if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                                    ghost.setDirection(movement.getDirection());
                                    ghost.setAnimated(true);
                                    ghostAnimation.movementAnimation(imageViewEntities);
                                }
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
                if (futureMovement == null) {
                    movement = null;
                    try {
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

    private synchronized void waitMovement(){
        try{
            if(!pause) {
                wait(time);
            }
            else {
                while(pause) {
                    wait();
                }
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Entity getEntity() {
        return ghost;
    }

    public synchronized void setMovement(Movement movement) {
        if (this.movement != null) {
            futureMovement = movement;

        } else {
            this.movement = movement;
            ghost.setDirection(movement.getDirection());
            notifyAll();
        }
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public void setImageViewEntities(ImageViewEntities imageViewEntities) {
        this.imageViewEntities = imageViewEntities;
    }

    public synchronized void setPause(boolean pause) {
       this.pause = pause;
       if(!pause){
           System.out.println(this.getName() + "/" +this.getState());
           notifyAll();
           System.out.println(this.getName() + "/" +this.getState());
       }
    }

    public void setKernelEngine(KernelEngine kernelEngine){}
}
