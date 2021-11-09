package pacman;

import Gameplay.SceneCase;

public class LabyrinthCase implements SceneCase {

    private boolean wallNorth;
    private boolean wallSouth;
    private boolean wallEast;
    private boolean wallWest;
    private int x;
    private int y;

    public LabyrinthCase(boolean wallNorth,boolean wallSouth,boolean wallEast, boolean wallWest, int x, int y){
        this.wallNorth = wallNorth;
        this.wallSouth = wallSouth;
        this.wallEast = wallEast;
        this.wallWest = wallWest;
        this.x = x;
        this.y = y;
    }

    public boolean getWallNorth(){
        return wallNorth;
    }

    public boolean getWallSouth(){
        return wallSouth;
    }

    public boolean getWallEast(){
        return wallEast;
    }

    public boolean getWallWest(){
        return wallWest;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
