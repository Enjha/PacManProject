package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanFull implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/pacman/pacman_full.gif").toURI().toString());
    }
}
