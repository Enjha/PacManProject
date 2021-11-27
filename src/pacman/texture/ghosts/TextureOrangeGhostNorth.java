package pacman.texture.ghosts;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureOrangeGhostNorth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/ghost/orange_ghost/orange_ghost_north.gif").toURI().toString());
    }
}
