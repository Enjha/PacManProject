package pacman.texture.wall;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleTopRight implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/angle/W_angle_top_right.gif").toURI().toString());
    }
}
