package pacman.texture;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleTopRight implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/angle/W_angle_top_right.gif").toURI().toString());
    }
}
