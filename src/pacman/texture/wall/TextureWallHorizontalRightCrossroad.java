package pacman.texture.wall;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallHorizontalRightCrossroad implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/crossroad/W_horizontal_right_crossroad.gif").toURI().toString());
    }
}
