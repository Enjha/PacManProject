package pacman.texture.wall;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallAngleBotRight implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/angle/W_angle_bot_right.gif").toURI().toString());
    }
}
