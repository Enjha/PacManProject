package ghost.texture.wall;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallDeadEndDown implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/dead_end/W_dead_end_down.gif").toURI().toString());
    }
}
