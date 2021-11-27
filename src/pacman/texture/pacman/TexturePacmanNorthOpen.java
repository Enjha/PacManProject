package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanNorthOpen implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/pacman/textures/pacman_north_open.gif").toURI().toString());
    }
}
