package Pacman;

import Gameplay.Team;
import Scene.SceneCase;
import Gameplay.Character;

public class Ghost implements Character{

    private SceneCase position;
    private Team team;

    public Ghost(SceneCase position, Team team){
        this.position = position;
        this.team = team;
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
}