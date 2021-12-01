package ghost.texture.ghosts;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureOrangeGhostSouth2 implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/orange_ghost/orange_ghost_south_2.gif").toURI().toString());
    }
}
