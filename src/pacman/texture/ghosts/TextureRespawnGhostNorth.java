package pacman.texture.ghosts;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureRespawnGhostNorth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/ghost/afraid/respawn_ghost_north.gif").toURI().toString());
    }
}
