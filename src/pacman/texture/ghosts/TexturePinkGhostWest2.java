package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePinkGhostWest2 implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/pink_ghost/pink_ghost_west_2.gif").toURI().toString());
    }
}
