package Scene;

import Gameplay.Direction;

public class Wall implements SceneElement{

    private Direction wallDirection;

    public Wall(Direction wallDirection){
        this.wallDirection = wallDirection;
    }

    public Direction getWallDirection(){
        return wallDirection;
    }
}
