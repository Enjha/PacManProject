package pacman.texture.pacman;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanDead9 implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/pacman/dead/pacman_dead9.gif").toURI().toString());
    }
}
