package pacman.texture.wall;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallCrossroad implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/crossroad/W_crossroad.gif").toURI().toString());
    }
}
