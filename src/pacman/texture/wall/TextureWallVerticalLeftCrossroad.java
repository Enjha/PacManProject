package pacman.texture.wall;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallVerticalLeftCrossroad implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/crossroad/W_vertical_left_crossroad.gif").toURI().toString());
    }
}
