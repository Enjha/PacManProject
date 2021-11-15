package scene;

import gameplay.Direction;

public class Wall implements SceneElement{

    private final Direction wallDirection;

    public Wall(Direction wallDirection){
        this.wallDirection = wallDirection;
    }

    public Direction getSceneElement(){
        return wallDirection;
    }
}
