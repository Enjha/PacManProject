package engines.UI;

import gameplay.Direction;
import gameplay.Entity;

/**
 * A key board control
 */
public class KeyBoardControl implements Control{

    /**
     * The key name
     */
    private String keyName;

    /**
     * The direction of this control
     */
    private final Direction direction;

    /**
     * The entity if this control
     */
    private final Entity entity;

    /**
     * <b>Constructor of KeyBoardControl</b>
     * @param keyName
     *      a key name
     * @param direction
     *      a direction
     * @param entity
     *      a entity
     */
    public KeyBoardControl(String keyName, Direction direction, Entity entity){
        assert keyName != null : "Error : key name null";
        assert direction != null : "Error : direction null";
        assert entity != null : "Error : entity null";
        this.keyName = keyName;
        this.direction = direction;
        this.entity = entity;
    }

    /**
     * Return the key name of this control
     * @return a string value
     */
    public String getKeyName(){
        return keyName;
    }

    /**
     * return the direction of this control
     * @return a object type of Control
     */
    public Direction getDirection(){
        return direction;
    }

    /**
     * Modify the key name of this control with a new one
     * @param keyName
     *       a new key name
     */
    public void setKeyName(String keyName){
        assert keyName != null : "Error : key name null";
        this.keyName = keyName;
    }

    /**
     * return the entity of this control
     * @return a object type of Entity
     */
    public Entity getEntity(){
        return entity;
    }
}
