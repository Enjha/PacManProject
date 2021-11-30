package pacman;

import gameplay.Entity;
import gameplay.Movement;
import gameplay.ThreadEntity;

public class ThreadGhost extends Thread implements ThreadEntity {

    private Ghost ghost;
    private Movement movement;
    private double time = 1000;

    public ThreadGhost(Ghost ghost){
        this.ghost = ghost;
    }

    public void run(){

    }

    public Entity getEntity(){
        return ghost;
    }

    public void setMovement(Movement movement){
        this.movement = movement;
    }
}
