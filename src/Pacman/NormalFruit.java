package Pacman;

import Gameplay.Item;
import Scene.SceneCase;

public class NormalFruit implements Item {

    private SceneCase position;

    public NormalFruit(SceneCase position){
        this.position = position;
    }

    public boolean isCharacter(){
        return false;
    }

    public boolean isItem(){
        return true;
    }

    public boolean canInteractWithItem(){
        return false;
    }

    public SceneCase getPosition(){
        return position;
    }
}
