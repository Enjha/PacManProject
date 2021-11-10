package Pacman;

import Gameplay.Character;
import Scene.SceneCase;

public class Pacman implements Character {

    private SceneCase position;

    public Pacman(SceneCase position){
        this.position = position;
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

    public boolean isEnemy(){
        return false;
    }

    public SceneCase getPosition(){
        return position;
    }
}
