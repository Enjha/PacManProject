package engines.IA;

import gameplay.Direction;
import gameplay.Entity;
import pacman.Ghost;
import pacman.Pacman;
import scene.SceneCase;

import java.util.ArrayList;
import java.util.Random;
/*
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
                if (true/*il y a un mur devant ou plusieurs possibilité de chemin alors*///){
 /*                   ArrayList<Direction> directions = initializeDirections();
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

    private double distBeetween(){ //calculer la distance mathématique entre le fantôme et pacman
        double distance = 0;
        SceneCase ghostPos = ghost.getPosition();
        SceneCase pacmanPos = pacman.getPosition();
        distance = Math.sqrt(Math.pow(ghostPos.getX() - pacmanPos.getX(), 2) + (Math.pow(ghostPos.getY() - pacmanPos.getY(), 2)));
        return distance;
    }

    private void followPM(){ //suivre PM en empruntant le chemin le plus court (par Dijkstra ou par indice de position)
        while(true){
            
        }
    }

    private ArrayList<Direction> initializeDirections(ArrayList<Direction> directions){


        return directions;
    }

    private ArrayList<Direction> pickGoodCase(ArrayList<Direction> directions){
        directions.remove(ghost.getDirection());

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
*/