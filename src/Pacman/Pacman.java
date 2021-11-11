package Pacman;

import Gameplay.Character;
import Gameplay.Team;
import Scene.SceneCase;

public class Pacman implements Character {

    private SceneCase position;
    private Team team;

    public Pacman(SceneCase position, Team team){
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
        return true;
    }

    public SceneCase getPosition(){
        return position;
    }

    public Team getTeam(){ return team; }
}
