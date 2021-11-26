package engines.graphic.view;

import gameplay.Direction;
import javafx.scene.image.Image;
import scene.SceneCase;
import scene.Wall;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WallView {

    public WallView() {
    }

    public Image getWallView(Object o) {
        SceneCase sceneCase = (SceneCase) o;
        List<Object> walls = sceneCase.getCaseContent(Wall.class.toString());
        /**
         * La list walls sera probablement null si la case contient aucun mur ! à corriger !
         */
        ArrayList<Direction> directions = new ArrayList<>();
        switch (walls.size()) {
            case 1:
                Wall w1 = (Wall) walls.get(0);
                switch (w1.getSceneElement()) {
                    case North:
                        return new Image(new File("ressources/wall/crossroad/W_vertical_down_crossroad.gif").toURI().toString());
                    case West:
                        return new Image(new File("ressources/wall/crossroad/W_horizontal_right_crossroad.gif").toURI().toString());
                    case South:
                        return new Image(new File("ressources/wall/crossroad/W_horizontal_up_crossroad.gif").toURI().toString());
                    case East:
                        return new Image(new File("ressources/wall/crossroad/W_vertical_left_crossroad.gif").toURI().toString());
                }
            case 2:
                directions.add(Direction.North);
                directions.add(Direction.South);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/corridor/W_vertical_corridor.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.West);
                directions.add(Direction.East);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/corridor/W_horizontal_corridor.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.North);
                directions.add(Direction.East);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/angle/W_angle_top_right.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.North);
                directions.add(Direction.West);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/angle/W_angle_top_left.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.South);
                directions.add(Direction.East);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/angle/W_angle_bot_right.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.South);
                directions.add(Direction.West);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/angle/W_angle_bot_left").toURI().toString());
                }
            case 3:
                directions.add(Direction.North);
                directions.add(Direction.East);
                directions.add(Direction.West);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/dead_end/W_dead_end_up.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.North);
                directions.add(Direction.East);
                directions.add(Direction.South);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/dead_end/W_dead_end_right.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.North);
                directions.add(Direction.West);
                directions.add(Direction.South);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/dead_end/W_dead_end_left.gif").toURI().toString());
                }
                directions = new ArrayList<>();
                directions.add(Direction.West);
                directions.add(Direction.East);
                directions.add(Direction.South);
                if (containDirection(walls, directions)) {
                    return new Image(new File("ressources/wall/dead_end/W_dead_end_down.gif").toURI().toString());
                }
            case 4:
                return new Image(new File("ressources/wall/W_square.gif").toURI().toString());
            default:
                return new Image(new File("ressources/wall/crossroad/W_crossroad.gif").toURI().toString());
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
