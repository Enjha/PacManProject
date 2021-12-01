package engines.IA;

import gameplay.Direction;
import pacman.Ghost;
import pacman.Pacman;
import scene.SceneCase;
import scene.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AiEntity implements Runnable{

    private final Ghost ghost;
    private final Pacman pacman;
    private final SceneCase[][] sceneCase;
    private boolean isAbleToFollow;
    private boolean calledByFollow = false;
    private boolean isAbleToTurnAround;
    private boolean calledByTurnAround = false;
    private boolean isFollowingPM;
    private boolean calledWhenFollowing = false;

    public AiEntity(Ghost ghost, Pacman pacman, SceneCase[][] sceneCase){
        this.ghost = ghost;
        this.pacman = pacman;
        this.sceneCase = sceneCase;
        isAbleToFollow = true;
        isAbleToTurnAround = true;
        isFollowingPM = false;
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
                List<Object> walls = sceneCase[ghost.getPosition().getX()][ghost.getPosition().getY()].getCaseContent(Wall.class.toString());
                if (isWallOrCrossRoad(walls)){ //il y a un mur devant ou plusieurs possibilité de chemin alors
                    ArrayList<Direction> directions = initializeDirections();
                    directions = pickGoodCases(directions);
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

    private boolean isWallOrCrossRoad(List<Object> walls){
        if(walls.isEmpty()) return true;
        int wallAround = 4;
        for(Object o : walls){
            Wall wall = (Wall) o;
            if (wall.getSceneElement() == ghost.getDirection())
                return true;
            wallAround--;
        }
        return wallAround < 2;
    }

    private double distBeetween(){ //calculer la distance mathématique entre le fantôme et pacman
        SceneCase ghostPos = ghost.getPosition();
        SceneCase pacmanPos = pacman.getPosition();
        return Math.sqrt(Math.pow(ghostPos.getX() - pacmanPos.getX(), 2) + (Math.pow(ghostPos.getY() - pacmanPos.getY(), 2)));
    }

    private void followPM(){ //suivre PM en empruntant le chemin le plus court (par Dijkstra ou par indice de position)
        isFollowingPM = true;
        Thread threadWhenImFollowingPM = new Thread();
        calledWhenFollowing = true;
        threadWhenImFollowingPM.start();
        while(isFollowingPM){

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

    private ArrayList<Direction> pickGoodCases(ArrayList<Direction> directions){ //remove les position ou le fantôme ne peux pas aller
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
            ghost.setDirection(getOppositeDrirection(ghost.getDirection()));
        }
    }

    private Direction getOppositeDrirection(Direction direction){
        if(direction == Direction.North)
            direction = Direction.South;
        else if(direction == Direction.East)
            direction = Direction.West;
        else if(direction == Direction.South)
            direction = Direction.North;
        else if(direction == Direction.West)
            direction = Direction.East;
        return direction;
    }

    @Override
    public void run() {
        try {
            if(calledByFollow){
                calledByFollow = false;
                Thread.sleep(10000); //il ne peux plus suivre PM pendant 10 secondes
                isAbleToFollow = true;
            }
            if(calledByTurnAround){
                calledByTurnAround = false;
                Thread.sleep(7000); //il ne peux plus faire demi-tour pendant 7 secondes
                isAbleToTurnAround = true;
            }
            if(calledWhenFollowing){
                calledWhenFollowing = false;
                Thread.sleep(10000); //il poursuit PM pendant 10 secondes
                isFollowingPM = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
