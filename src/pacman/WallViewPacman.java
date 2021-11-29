package pacman;

import engines.graphic.view.WallView;
import gameplay.Direction;
import javafx.scene.image.Image;
import pacman.texture.wall.*;
import scene.SceneCase;
import scene.Wall;

import java.util.ArrayList;
import java.util.List;

public class WallViewPacman implements WallView {

    public Image getWallView(SceneCase sceneCase) {
        List<Object> walls = sceneCase.getCaseContent(Wall.class.toString());

        int sizeWall;
        if(walls == null) {
            sizeWall = 0;
        }
        else {
            sizeWall = walls.size();
        }
        ArrayList<Direction> directions = new ArrayList<>();
            switch (sizeWall) {
                case 1:
                    Wall w1 = (Wall) walls.get(0);
                    switch (w1.getSceneElement()) {
                        case North:
                            return new TextureWallVerticalDownCrossroad().getTexture();
                        case West:
                            return new TextureWallHorizontalRightCrossroad().getTexture();
                        case South:
                            return new TextureWallHorizontalUpCrossroad().getTexture();
                        case East:
                            return new TextureWallVerticalLeftCrossroad().getTexture();
                    }
                case 2:
                    directions.add(Direction.North);
                    directions.add(Direction.South);
                    if (containDirection(walls, directions)) {
                        return new TextureWallVerticalCorridor().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.West);
                    directions.add(Direction.East);
                    if (containDirection(walls, directions)) {
                        return new TextureWallHorizontalCorridor().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.North);
                    directions.add(Direction.East);
                    if (containDirection(walls, directions)) {
                        return new TextureWallAngleTopRight().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.North);
                    directions.add(Direction.West);
                    if (containDirection(walls, directions)) {
                        return new TextureWallAngleTopLeft().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.South);
                    directions.add(Direction.East);
                    if (containDirection(walls, directions)) {
                        return new TextureWallAngleBotRight().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.South);
                    directions.add(Direction.West);
                    if (containDirection(walls, directions)) {
                        return new TextureWallAngleBotLeft().getTexture();
                    }
                case 3:
                    directions.add(Direction.North);
                    directions.add(Direction.East);
                    directions.add(Direction.West);
                    if (containDirection(walls, directions)) {
                        return new TextureWallDeadEndUp().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.North);
                    directions.add(Direction.East);
                    directions.add(Direction.South);
                    if (containDirection(walls, directions)) {
                        return new TextureWallDeadEndRight().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.North);
                    directions.add(Direction.West);
                    directions.add(Direction.South);
                    if (containDirection(walls, directions)) {
                        return new TextureWallDeadEndLeft().getTexture();
                    }
                    directions = new ArrayList<>();
                    directions.add(Direction.West);
                    directions.add(Direction.East);
                    directions.add(Direction.South);
                    if (containDirection(walls, directions)) {
                        return new TextureWallDeadEndDown().getTexture();
                    }
                case 4:
                    return new TextureWallSquare().getTexture();
                default:
                    return new TextureWallCrossroad().getTexture();
            }
    }

    public boolean containDirection(List<Object> walls, List<Direction> directions) {
        int i = directions.size();
        for (Object o : walls) {
            Wall w = (Wall) o;
            if (directions.contains(w.getSceneElement())) {
                directions.remove(w.getSceneElement());
                i--;
            }
        }
        return i == 0;
    }

}
