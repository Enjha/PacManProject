package pacman;

import gameplay.Item;
import scene.SceneCase;

/**
 * The entity normal fruit
 */
public class NormalFruit implements Item {

    /**
     * The scene case who contain pacman
     */
    private SceneCase position;

    /**
     * The name of pacgum fruit
     */
    private String entityName = "Fruit";

    /**
     * Return if this entity is a character
     * @return a boolean value equal to false
     */
    public boolean isCharacter(){
        return false;
    }

    /**
     * Return if this entity is a item
     * @return a boolean value equal to true
     */
    public boolean isItem(){
        return true;
    }

    /**
     * Return if this entity can interact with item
     * @return a boolean value equal to false
     */
    public boolean canInteractWithItem(){
        return false;
    }

    /**
     * Return the scene case who contain this entity
     * @return a object type of SceneCase
     */
    public SceneCase getPosition(){
        return position;
    }

    /**
     * Modify the scene case who contain this entity
     * @param position
     *      a new scene case
     */
    public void setPosition(SceneCase position){
        this.position = position;
    }

    /**
     * Return this entity's name
     * @return a string value
     */
    public String getEntityName(){
        return entityName;
    }
}
