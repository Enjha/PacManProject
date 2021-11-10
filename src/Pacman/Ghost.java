package Pacman;

import Scene.SceneCase;
import Gameplay.Character;

public class Ghost implements Character{

    private SceneCase position;

    public Ghost(SceneCase position){
        this.position = position;
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

    public boolean isEnemy(){
        return true;
    }

    public SceneCase getPosition(){
        return position;
    }
}