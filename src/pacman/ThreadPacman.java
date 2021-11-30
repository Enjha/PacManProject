package pacman;

import gameplay.*;

public class ThreadPacman extends Thread implements ThreadEntity {

    private Pacman pacman;
    private long time = 2000;
    private Movement movement;
    private boolean end = false;
    private Game game;

    public ThreadPacman(Pacman pacman,Game game){
        this.pacman = pacman;
        this.game = game;
    }

    public void run(){
        while(!end){
            if(pacman.getDirection() != Direction.Stop){
                game.treatmentCollisionGame(movement);
                try {
                    sleep(time);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }


    public void setMovement(Movement movement){
        this.movement = movement;
        if(pacman.getDirection() == Direction.Stop){
            pacman.setDirection(movement.getDirection());
            //System.err.println("direction : " + pacman.getDirection());
        }
    }

    public Entity getEntity(){
        return pacman;
    }

}
