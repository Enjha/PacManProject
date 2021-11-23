package engines.UI;

import gameplay.Direction;
import gameplay.Entity;
import javafx.scene.input.KeyEvent;

public class KeyBoardControl implements Control{

    private String key;
    private Direction direction;
    private Entity entity;

    public KeyBoardControl(String key,Direction direction,Entity entity){
        this.key = key;
        this.direction = direction;
        this.entity = entity;
    }

    public String getKey(){
        return key;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setKey(String key){
        this.key = key;
    }

    public Entity getEntity(){
        return entity;
    }
}
