package engines.IA;

import gameplay.Direction;
import gameplay.Entity;
import pacman.Ghost;
import pacman.Pacman;
import scene.SceneCase;

import java.util.ArrayList;
import java.util.Random;

public class AiEntity implements Runnable{

    private Entity entity;
    private Ghost ghost;
    private Pacman pacman;
    private boolean isAbleToFollow;
    private boolean calledByFollow = false;
    private boolean isAbleToTurnAround;
    private boolean calledByTurnAround = false;
    private boolean imFollowingPM;
    private boolean calledWhenFollowing = false;

    public AiEntity(Entity entity, Ghost ghost, Pacman pacman){
        this.entity = entity;
        this.ghost = ghost;
        this.pacman = pacman;
        isAbleToFollow = true;
        isAbleToTurnAround = true;
        imFollowingPM = false;
        moove();
    }

    private void moove(){ //permet au fantôme de se deplacer
        ghost.setDirection(Direction.North);
        while(ghost.isAlive()){
            if(distBeetween() <= 7 && isAbleToFollow){ //ghost va passer dans l'état de déplacement "poursuite"
                isAbleToFollow = false;
                followPM();
                Thread threadFollow = new Thread();
                calledByFollow = true;
                threadFollow.start();
            }
            else{ //ghost va rester dans un état de déplacement "classique"
                if (isWallOrCrossRoad()){ //il y a un mur devant ou plusieurs possibilité de chemin alors
                    ArrayList<Direction> directions = initializeDirections();
                    directions = pickGoodCase(directions);
                    pickDirection(directions);
                }
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
    private boolean isWallOrCrossRoad(){

        return true;
    }

    private double distBeetween(){ //calculer la distance mathématique entre le fantôme et pacman
        SceneCase ghostPos = ghost.getPosition();
        SceneCase pacmanPos = pacman.getPosition();
        return Math.sqrt(Math.pow(ghostPos.getX() - pacmanPos.getX(), 2) + (Math.pow(ghostPos.getY() - pacmanPos.getY(), 2)));
    }

    private void followPM(){ //suivre PM en empruntant le chemin le plus court (par Dijkstra ou par indice de position)
        while(imFollowingPM){
            
        }
    }

    private ArrayList<Direction> initializeDirections(){
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.North);
        directions.add(Direction.East);
        directions.add(Direction.South);
        directions.add(Direction.West);
        return directions;
    }

    private ArrayList<Direction> pickGoodCase(ArrayList<Direction> directions){ //remove les position ou le fantôme ne peux pas aller
        directions.remove(ghost.getDirection());
        for(int i = 0; i < directions.size(); i++){
            if(true/*ghost.setDirection(directions.get(i)) != possible*/);
            directions.remove(i);
        }
        return directions;
    }

    private void pickDirection(ArrayList<Direction> directions){ //choisir un directions entre celles qui sont possibles
        Random random = new Random();
        int choice = random.nextInt(directions.size());
        ghost.setDirection(directions.get(choice));
    }

    private void turnAround(){ //le fantôme a une chance faire demi-tour
        Random random = new Random();
        int choice = random.nextInt(3);
        if (choice == 1) { //une chance sur trois de changer de direction
            if (ghost.getDirection() == Direction.North)
                ghost.setDirection(Direction.South);
            if (ghost.getDirection() == Direction.East)
                ghost.setDirection(Direction.West);
            if (ghost.getDirection() == Direction.South)
                ghost.setDirection(Direction.North);
            if (ghost.getDirection() == Direction.West)
                ghost.setDirection(Direction.East);
        }
    }

    @Override
    public void run() {
        try {
            if(calledByFollow){
                calledByFollow = false;
                Thread.sleep(10000); //il ne peux plus suivre PM pednant 10 secondes
                isAbleToFollow = true;
            }
            if(calledByTurnAround){
                calledByTurnAround = false;
                Thread.sleep(7000); //il ne peux plus faire demi-tour pendant 7 secondes
                isAbleToTurnAround = true;
            }
            if(imFollowingPM){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
