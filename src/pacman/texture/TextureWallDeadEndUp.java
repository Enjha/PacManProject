package pacman.texture;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallDeadEndUp implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/dead_end/W_dead_end_up.gif").toURI().toString());
    }
}
