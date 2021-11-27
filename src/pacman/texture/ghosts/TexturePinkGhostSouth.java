package pacman.texture.ghosts;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePinkGhostSouth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/ghost/pink_ghost/pink_ghost_south.gif").toURI().toString());
    }
}
