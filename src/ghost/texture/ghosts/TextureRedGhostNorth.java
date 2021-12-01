package ghost.texture.ghosts;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureRedGhostNorth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/red_ghost/red_ghost_north.gif").toURI().toString());
    }
}
