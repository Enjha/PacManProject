package pacman.texture.ghosts;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureRespawnGhostSouth implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/ghost/afraid/respawn_ghost_south.gif").toURI().toString());
    }
}
