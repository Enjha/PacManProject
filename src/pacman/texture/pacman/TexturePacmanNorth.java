package pacman.texture.pacman;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanNorth implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_north.gif").toURI().toString());
    }
}
