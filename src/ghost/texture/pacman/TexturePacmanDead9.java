package ghost.texture.pacman;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePacmanDead9 implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/pacman/dead/pacman_dead9.gif").toURI().toString());
    }
}
