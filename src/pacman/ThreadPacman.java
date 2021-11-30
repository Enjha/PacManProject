package pacman;

import gameplay.*;

public class ThreadPacman extends Thread implements ThreadEntity {

    private Pacman pacman;
    private long time = 1000;
    private Movement movement;
    private boolean end = false;
    private Game game;
    private Movement futureMovement = null;
    private boolean collision = false;

    public ThreadPacman(Pacman pacman,Game game){
        this.pacman = pacman;
        this.game = game;
    }

    public synchronized void run(){
        while(!end){
            if(pacman.getDirection() != Direction.Stop){
                if(futureMovement != null){
                    if(collision){
                        game.treatmentCollisionGame(movement);
                        if(collision){
                            futureMovement = null;
                        }
                    }
                    else {
                        game.treatmentCollisionGame(futureMovement);
                        if(!collision){
                            movement = futureMovement;
                            futureMovement = null;
                        }
                    }
                }
                else {
                    if(movement != null) {
                        game.treatmentCollisionGame(movement);
                    }
                }
                try {
                    if(!collision) {
                        wait(time);
                    }
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            else {
                if(futureMovement == null) {
                    movement = null;
                    try {
                        while(movement == null) {
                            wait();
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                else{
                    if(collision){
                        pacman.setDirection(movement.getDirection());
                    }
                }
            }
        }
    }



    public synchronized void setMovement(Movement movement){
        if(this.movement != null) {
            futureMovement = movement;
        }
        else {
            this.movement = movement;
            notifyAll();
            pacman.setDirection(movement.getDirection());
        }
    }

    public Entity getEntity(){
        return pacman;
    }

    public void setCollision(boolean collision){
       this.collision = collision;
    }
}
