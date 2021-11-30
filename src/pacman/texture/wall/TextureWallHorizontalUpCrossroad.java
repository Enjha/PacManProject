package pacman.texture.wall;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallHorizontalUpCrossroad implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/crossroad/W_horizontal_up_crossroad.gif").toURI().toString());
    }
}
