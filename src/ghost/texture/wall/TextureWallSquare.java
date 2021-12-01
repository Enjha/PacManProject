package ghost.texture.wall;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallSquare implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/W_square.gif").toURI().toString());
    }
}
