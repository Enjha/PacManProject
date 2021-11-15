package engines.graphic;

import api.FxAPI;

/**
 * Élément graphique pour couvrir une entité graphique
 */
public abstract class Cover extends FxAPI {
    /**
     * Recouvrir une entité graphique
     * @param graphicEntity carreau
     */
    protected abstract void cover(GraphicEntity graphicEntity);

    /**
     * Mettre à jour l'élément graphique
     */
    protected abstract void update();

    /**
     * Cloner l'élément graphique
     */
    public abstract Cover clone();
}
