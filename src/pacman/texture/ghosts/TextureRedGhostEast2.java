package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureRedGhostEast2 implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/textures/ghost/red_ghost/red_ghost_east_2.gif").toURI().toString());
    }
}
