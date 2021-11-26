package pacman;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Team;
import scene.SceneCase;

public class Pacman implements Character {

    private SceneCase position;
    private Team team;
    private String entityName = "Pac-Man";
    private Direction direction = Direction.Stop;

    public boolean isCharacter(){
        return true;
    }

    public boolean isItem(){
        return false;
    }

    public boolean canInteractWithItem(){
        return true;
    }

    public SceneCase getPosition(){
        return position;
    }

    public Team getTeam(){ return team; }

    public void setPosition(SceneCase position){
        this.position = position;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public String getEntityName(){
        return entityName;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
