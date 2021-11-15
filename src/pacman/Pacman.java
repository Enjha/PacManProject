package pacman;

import gameplay.Character;
import gameplay.Team;
import scene.SceneCase;

public class Pacman implements Character {

    private final SceneCase position;
    private final Team team;

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
