package ghost.texture.ghosts;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureAfraidGhostBlue implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/afraid/afraid_ghost_blue.gif").toURI().toString());
    }
}
