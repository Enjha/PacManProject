package pacman.texture;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallDeadEndDown implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/dead_end/W_dead_end_down.gif").toURI().toString());
    }
}
