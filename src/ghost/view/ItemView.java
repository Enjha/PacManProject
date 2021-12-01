package ghost.view;

import gameplay.Item;
import javafx.scene.image.Image;
import ghost.NormalFruit;
import ghost.PacgumFruit;
import ghost.texture.items.TextureFruit;
import ghost.texture.items.TexturePacGum;

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
