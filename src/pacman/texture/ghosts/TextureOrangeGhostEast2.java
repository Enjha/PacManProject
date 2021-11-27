package pacman.texture.ghosts;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureOrangeGhostEast2 implements Texture {
    @Override
    public Image getTexture() {
        return new Image(new File("ressources/ghost/orange_ghost/orange_ghost_east_2.gif").toURI().toString());
    }
}
