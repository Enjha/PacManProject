package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureOrangeGhostWest implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/orange_ghost/orange_ghost_west.gif").toURI().toString());
    }
}
