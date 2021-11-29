package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureRespawnGhostWest implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/afraid/respawn_ghost_west.gif").toURI().toString());
    }
}
