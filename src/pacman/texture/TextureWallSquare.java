package pacman.texture;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallSquare implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/W_square.gif").toURI().toString());
    }
}
