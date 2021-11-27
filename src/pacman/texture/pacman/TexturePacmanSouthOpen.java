package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanSouthOpen implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_south_open.gif").toURI().toString());
    }
}
