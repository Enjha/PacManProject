package ghost.texture.wall;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleTopLeft implements Texture {

    public Image getTexture(){
        return new javafx.scene.image.Image(new File("ressources/textures/wall/angle/W_angle_top_left.gif").toURI().toString());
    }
}
