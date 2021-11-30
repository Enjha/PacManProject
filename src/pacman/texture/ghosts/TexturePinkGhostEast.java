package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePinkGhostEast implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/pink_ghost/pink_ghost_east.gif").toURI().toString());
    }
}
