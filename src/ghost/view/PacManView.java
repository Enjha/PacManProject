package ghost.view;

import javafx.scene.image.Image;
import ghost.Pacman;
import ghost.texture.pacman.*;

import java.util.ArrayList;

/**
 * Gère les textures de l'entité Pacman
 */
public class PacManView {

    /**
     * Cette classe va prendre en entrée l'entité et va en fonction de si il est en vie ou pas et de sa direction
     * retourné la texture qui correspond.
     *
     * @param pacman l'entité concernée
     * @return la liste des images de l'entité avec la position concerné (liste car plusieurs images
     * nécessaire pour l'animation de l'entité).
     */
    public ArrayList<Image> getPacmanView(Pacman pacman) {
        ArrayList<Image> pacman_views = new ArrayList<>();
        switch (pacman.getDirection()) {
            case North:
                pacman_views.add(new TexturePacmanNorth().getTexture());
                pacman_views.add(new TexturePacmanNorthOpen().getTexture());
                return pacman_views;
            case East:
                pacman_views.add(new TexturePacmanEast().getTexture());
                pacman_views.add(new TexturePacmanEastOpen().getTexture());
                return pacman_views;
            case South:
                pacman_views.add(new TexturePacmanSouth().getTexture());
                pacman_views.add(new TexturePacmanSouthOpen().getTexture());
                return pacman_views;
            case West:
                pacman_views.add(new TexturePacmanWest().getTexture());
                pacman_views.add(new TexturePacmanWestOpen().getTexture());
                return pacman_views;
            case Stop:
                if (!pacman.isAlive()) {
                    pacman_views.add(new TexturePacmanDead1().getTexture());
                    pacman_views.add(new TexturePacmanDead2().getTexture());
                    pacman_views.add(new TexturePacmanDead3().getTexture());
                    pacman_views.add(new TexturePacmanDead4().getTexture());
                    pacman_views.add(new TexturePacmanDead5().getTexture());
                    pacman_views.add(new TexturePacmanDead6().getTexture());
                    pacman_views.add(new TexturePacmanDead7().getTexture());
                    pacman_views.add(new TexturePacmanDead8().getTexture());
                    pacman_views.add(new TexturePacmanDead9().getTexture());
                    pacman_views.add(new TexturePacmanDead10().getTexture());
                    pacman_views.add(new TexturePacmanDead11().getTexture());
                    return pacman_views;
                } else {
                    pacman_views.add(new TexturePacmanFull().getTexture());
                    return pacman_views;
                }
        }
        return null;

    }
}
