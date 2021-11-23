package pacman;

import gameplay.Item;
import scene.SceneCase;

public class NormalFruit implements Item {

    private SceneCase position;
    private String entityName = "Fruit";

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

    public void setPosition(SceneCase position){
        this.position = position;
    }

    public String getEntityName(){
        return entityName;
    }
}
