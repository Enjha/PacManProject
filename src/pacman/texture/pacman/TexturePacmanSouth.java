package pacman.texture.pacman;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanSouth implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_south.gif").toURI().toString());
    }
}
