package ghost.texture.ghosts;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureBlueGhostNorth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/blue_ghost/blue_ghost_north.gif").toURI().toString());
    }
}
