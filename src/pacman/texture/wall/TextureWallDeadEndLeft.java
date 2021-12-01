package pacman.texture.wall;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallDeadEndLeft implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/dead_end/W_dead_end_left.gif").toURI().toString());
    }
}
