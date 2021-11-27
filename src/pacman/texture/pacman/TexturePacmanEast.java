package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanEast implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/pacman_east.gif").toURI().toString());
    }
}
