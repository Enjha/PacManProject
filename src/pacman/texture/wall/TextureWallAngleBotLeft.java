package pacman.texture.wall;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleBotLeft implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/angle/W_angle_bot_left.gif").toURI().toString());
    }
}
