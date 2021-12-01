package ghost.texture.pacman;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanWestOpen implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_west_open.gif").toURI().toString());
    }
}
