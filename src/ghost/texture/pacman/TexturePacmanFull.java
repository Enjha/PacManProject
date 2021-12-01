package ghost.texture.pacman;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanFull implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_full.gif").toURI().toString());
    }
}
