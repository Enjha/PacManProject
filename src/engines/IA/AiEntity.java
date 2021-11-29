package engines.IA;

import gameplay.Direction;
import gameplay.Entity;
import pacman.Ghost;
import pacman.Pacman;

public class AiEntity implements Runnable{

    private Entity entity;
    private Ghost ghost;
    private Pacman pacman;
    private boolean isAbleToFollow;
    private boolean isAbleToTurnAround;
    private boolean calledByFollow = false;
    private boolean calledByTurnAround = false;

    public AiEntity(Entity entity, Ghost ghost, Pacman pacman){
        this.entity = entity;
        this.ghost = ghost;
        this.pacman = pacman;
        isAbleToFollow = true;
        isAbleToTurnAround = true;
        moove();
    }

    private void moove(){
        ghost.setDirection(Direction.North);
        while(ghost.isAlive()){
            if(algoDijkstra() <= 7 && isAbleToFollow){ //ghost va passer dans l'état de déplacement "poursuite"
                followPM();
                isAbleToFollow = false;
                Thread threadFollow = new Thread();
                calledByFollow = true;
                threadFollow.start();
            }
            else{ //ghost va rester dans un état de déplacement "classique"
              /*  if (*si on se trouve à une intersection){
                    pickDirection();
               } */
                if(isAbleToTurnAround){
                    turnAround();
                    isAbleToTurnAround = false;
                    Thread threadTurnAround = new Thread();
                    calledByTurnAround = true;
                    threadTurnAround.start();
                }
            }
        }
    }

    private int algoDijkstra(){
        int distance = 0;


        return distance;
    }

    private void followPM(){

    }

    private void pickDirection(){
        int choice = 1 + (int)(Math.random() * 5);
        switch(choice){
            case 1:
                ghost.setDirection(Direction.North);
                break;
            case 2:
                ghost.setDirection(Direction.East);
                break;
            case 3:
                ghost.setDirection(Direction.South);
                break;
            case 4:
                ghost.setDirection(Direction.West);
                break;
            default :
                System.err.println("Error with direction in AI motor");
                break;
        }
    }

    private void turnAround(){
        int choice = 1 + (int)(Math.random() * 3);
        switch(choice){
            case 1:
                if(ghost.getDirection() == Direction.North)
                    ghost.setDirection(Direction.South);
                if(ghost.getDirection() == Direction.East)
                    ghost.setDirection(Direction.West);
                if(ghost.getDirection() == Direction.South)
                    ghost.setDirection(Direction.North);
                if(ghost.getDirection() == Direction.West)
                    ghost.setDirection(Direction.East);
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        try {
            if(calledByFollow){
                calledByFollow = false;
                Thread.sleep(10000);
                isAbleToFollow = true;
            }
            if(calledByTurnAround){
                calledByTurnAround = false;
                Thread.sleep(7000);
                isAbleToTurnAround = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
