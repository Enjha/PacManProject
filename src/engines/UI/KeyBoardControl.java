package engines.UI;

import gameplay.Direction;
import javafx.scene.input.KeyEvent;

public class KeyBoardControl implements Control{

    private String key;
    private Direction direction;

    public KeyBoardControl(String key,Direction direction){
        this.key = key;
        this.direction = direction;
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
}
