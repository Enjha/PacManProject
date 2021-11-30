package pacman.texture.ghosts;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TexturePinkGhostSouth implements Texture {
    @Override
    public Image getTexture() {
        System.out.println("test");
        return new Image(new File("ressources/textures/ghost/pink_ghost/pink_ghost_south.gif").toURI().toString());
    }
}
