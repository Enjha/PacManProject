package pacman;

import gameplay.Direction;
import gameplay.Team;
import scene.SceneCase;
import gameplay.Character;

public class Ghost implements Character{

    private SceneCase position;
    private Team team;
    private String entityName;
    private Direction direction = Direction.Stop;
    private boolean isAlive = true;

    public Ghost(String entityName){
        this.entityName = entityName;
    }

    public boolean isCharacter(){
        return true;
    }

    public boolean isItem(){
        return false;
    }

    public boolean canInteractWithItem(){
        return false;
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

    public boolean isAlive(){
        return isAlive;
    }
}