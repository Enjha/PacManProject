package pacman.texture;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleTopLeft implements Texture {

    public Image getTexture(){
        return new javafx.scene.image.Image(new File("ressources/wall/angle/W_angle_top_left.gif").toURI().toString());
    }
}
