package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanDead7 implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/pacman/dead/pacman_dead7.gif").toURI().toString());
    }
}
