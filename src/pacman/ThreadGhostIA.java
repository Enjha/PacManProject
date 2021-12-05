package pacman;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;
import gameplay.Entity;
import gameplay.Game;
import gameplay.Movement;
import gameplay.ThreadEntity;
import pacman.animations.GhostAnimation;

public class ThreadGhostIA extends Thread implements ThreadEntity {

    private final Ghost ghost;
    private final Game game;
    private Movement movement;
    private Collision collision = null;
    private ImageViewEntities imageViewEntities;
    private boolean pause = false;
    private long time = 180;
    private GhostAnimation ghostAnimation = null;
    private boolean end = false;
    private KernelEngine kernelEngine;

    public ThreadGhostIA(Ghost ghost, Game game){
        this.ghost = ghost;
        this.game = game;
        ghostAnimation = new GhostAnimation();
    }

    public synchronized void run(){
        while(!end){
            setMovement(kernelEngine.getMovementIA(ghost));
            game.treatmentCollisionGame(movement);
            if(collision == null){
                ghostAnimation.movementAnimation(imageViewEntities);
            }
        }
    }


    public Entity getEntity() {
        return ghost;
    }

    public synchronized void setMovement(Movement movement) {
        ghost.setDirection(movement.getDirection());
        this.movement = movement;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public void setImageViewEntities(ImageViewEntities imageViewEntities) {
        this.imageViewEntities = imageViewEntities;
        System.out.println(imageViewEntities.getEntity().getEntityName() + "/" + ghost.getEntityName());
    }

    public synchronized void setPause(boolean pause) {
        this.pause = pause;
        if(!pause){
            System.out.println(this.getName() + "/" +this.getState());
            notifyAll();
            System.out.println(this.getName() + "/" +this.getState());
        }
    }

    public void setKernelEngine(KernelEngine kernelEngine){
        this.kernelEngine = kernelEngine;
    }
}
