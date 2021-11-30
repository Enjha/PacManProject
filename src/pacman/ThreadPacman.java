package pacman;

import engines.graphic.ImageViewEntities;
import gameplay.*;
import pacman.animations.PacManAnimation;

public class ThreadPacman extends Thread implements ThreadEntity {

    private Pacman pacman;
    private long time = 200;
    private Movement movement;
    private boolean end = false;
    private Game game;
    private Movement futureMovement = null;
    private boolean collision = false;
    private ImageViewEntities imageViewEntities;
    private final PacManAnimation pacManAnimation;

    public ThreadPacman(Pacman pacman, Game game) {
        this.pacman = pacman;
        this.game = game;
        this.pacManAnimation = new PacManAnimation();
    }

    public synchronized void run() {
        while (!end) {
            if (pacman.getDirection() != Direction.Stop) {
                if (futureMovement != null) {
                    if (collision) {
                        game.treatmentCollisionGame(movement);
                        if (collision) {
                            futureMovement = null;
                        } else {
                            pacManAnimation.movementAnimation(imageViewEntities);
                        }
                    } else {
                        game.treatmentCollisionGame(futureMovement);
                        if (!collision) {
                            movement = futureMovement;
                            futureMovement = null;
                            pacman.setDirection(movement.getDirection());
                            pacManAnimation.movementAnimation(imageViewEntities);
                        }
                    }
                } else {
                    if (movement != null) {
                        game.treatmentCollisionGame(movement);
                        if (!collision) {
                            pacManAnimation.movementAnimation(imageViewEntities);
                        }
                    }
                }
                try {
                    if (!collision) {
                        wait(time);
                    }
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            } else {
                if (futureMovement == null) {
                    movement = null;
                    try {
                        while (movement == null) {
                            wait();
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                } else {
                    if (collision) {
                        pacman.setDirection(movement.getDirection());
                    }
                }
            }
        }
    }

    public void setImageViewEntities(ImageViewEntities imageViewEntities) {
        pacman = (Pacman) imageViewEntities.getEntity();
        this.imageViewEntities = imageViewEntities;
    }

    public synchronized void setMovement(Movement movement) {
        if (this.movement != null) {
            futureMovement = movement;
        } else {
            this.movement = movement;
            notifyAll();
        }
        pacman.setDirection(movement.getDirection());
    }

    public Entity getEntity() {
        return pacman;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
