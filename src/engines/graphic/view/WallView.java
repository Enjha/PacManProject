package engines.graphic.view;

import javafx.scene.image.Image;
import scene.SceneCase;
import scene.Wall;

import java.util.List;
import java.util.Objects;

public class WallView {

    //ANGLE
    private final Image W_angle_top_left;
    private final Image W_angle_right_left;
    private final Image W_angle_bot_left;
    private final Image W_angle_left_left;

    //CORRIDOR
    private final Image W_horizontal_corridor;
    private final Image W_vertical_corridor;

    //CROSSROAD
    private final Image W_crossroad;
    private final Image W_horizontal_up_crossroad;
    private final Image W_horizontal_right_crossroad;
    private final Image W_vertical_down_crossroad;
    private final Image W_vertical_left_crossroad;

    //DEAD_END
    private final Image W_dead_end_up;
    private final Image W_dead_end_right;
    private final Image W_dead_end_down;
    private final Image W_dead_end_left;

    //PARTICULAR
    private final Image W_ghost_exit;
    private final Image W_square;

    public WallView() {
        W_angle_top_left = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_angle_top_left.gif")));
        W_angle_right_left = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_angle_right_left.gif")));
        W_angle_bot_left = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_angle_bot_left.gif")));
        W_angle_left_left = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_angle_left_left.gif")));
        W_horizontal_corridor = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_horizontal_corridor.gif")));
        W_vertical_corridor = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_vertical_corridor.gif")));
        W_crossroad = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_crossroad.gif")));
        W_horizontal_up_crossroad = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_horizontal_up_crossroad.gif")));
        W_horizontal_right_crossroad = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_horizontal_right_crossroad.gif")));
        W_vertical_down_crossroad = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_vertical_down_crossroad.gif")));
        W_vertical_left_crossroad = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_vertical_left_crossroad.gif")));
        W_dead_end_up = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_dead_end_up.gif")));
        W_dead_end_right = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_dead_end_right.gif")));
        W_dead_end_down = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_dead_end_down.gif")));
        W_dead_end_left = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_dead_end_left.gif")));
        W_ghost_exit = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_ghost_exit.gif")));
        W_square = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/wall/W_square.gif")));
    }

    public Image getWallView(Object o){
        SceneCase sceneCase = (SceneCase) o;
        //Récupérer les direction du mur (en fonction de la case en paramètre) et renvoyer l'image qui correspond au cas !
        List<Object> list = sceneCase.getCaseContent(Wall.class.toString());
        Wall wall = (Wall) list.get(0);


        return null;
    }

}
