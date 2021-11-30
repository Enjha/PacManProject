package pacman.view;

import gameplay.Item;
import javafx.scene.image.Image;
import pacman.NormalFruit;
import pacman.PacgumFruit;
import pacman.texture.items.TextureFruit;
import pacman.texture.items.TexturePacGum;

/**
 * Gère les textures de l'entité Item (Fruit et Pac-gum)
 */
public class ItemView {

    /**
     * Cette classe va prendre en entrée l'entité et va en fonction de son instance (Fruit ou Pac-gum) retourné la texture qui correspond.
     *
     * @param item l'entité concernée
     * @return L'image de l'entité concerné.
     */
    public Image getItemView(Item item) {
        if (item instanceof NormalFruit) {
            return new TextureFruit().getTexture();
        } else if (item instanceof PacgumFruit) {
            return new TexturePacGum().getTexture();
        }
        return null;
    }
}
