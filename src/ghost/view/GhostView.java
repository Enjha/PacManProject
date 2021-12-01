package ghost.view;

import javafx.scene.image.Image;
import ghost.Ghost;
import ghost.texture.ghosts.*;

import java.util.ArrayList;

/**
 * Gère les textures de l'entité Ghost
 */
public class GhostView {

    /**
     * Cette classe va prendre en entrée l'entité et va en fonction de sa direction sa couleur etc .. retourné la texture qui correspond.
     *
     * @param ghost l'entité concernée
     * @return la liste des images de l'entité avec la position concerné (liste car plusieurs images
     * nécessaire pour l'animation de l'entité).
     */
    // Reste à faire le cas ou pacman a son pouvoir et le fantome est donc dans un état AFRAID clignotement.
    public ArrayList<Image> getGhostView(Ghost ghost) {
        ArrayList<Image> ghost_views = new ArrayList<>();
        if (ghost.isAfraid()) {
            ghost_views.add(new TextureAfraidGhostBlue().getTexture());
            ghost_views.add(new TextureAfraidGhostBlue().getTexture());
            ghost_views.add(new TextureAfraidGhostBlue().getTexture());
            ghost_views.add(new TextureAfraidGhostBlue().getTexture());
            return ghost_views;
        }
        switch (ghost.getDirection()) {
            case North:
                if (!ghost.isAlive()) {
                    ghost_views.add(new TextureDeadGhostNorth().getTexture());
                    return ghost_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        ghost_views.add(new TextureBlueGhostNorth().getTexture());
                        ghost_views.add(new TextureBlueGhostNorth2().getTexture());
                        return ghost_views;
                    case ORANGE:
                        ghost_views.add(new TextureOrangeGhostNorth().getTexture());
                        ghost_views.add(new TextureOrangeGhostNorth2().getTexture());
                        return ghost_views;
                    case PINK:
                        ghost_views.add(new TexturePinkGhostNorth().getTexture());
                        ghost_views.add(new TexturePinkGhostNorth2().getTexture());
                        return ghost_views;
                    case RED:
                        ghost_views.add(new TextureRedGhostNorth().getTexture());
                        ghost_views.add(new TextureRedGhostNorth2().getTexture());
                        return ghost_views;
                }
            case East:
                if (!ghost.isAlive()) {
                    ghost_views.add(new TextureDeadGhostEast().getTexture());
                    return ghost_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        ghost_views.add(new TextureBlueGhostEast().getTexture());
                        ghost_views.add(new TextureBlueGhostEast2().getTexture());
                        return ghost_views;
                    case ORANGE:
                        ghost_views.add(new TextureOrangeGhostEast().getTexture());
                        ghost_views.add(new TextureOrangeGhostEast2().getTexture());
                        return ghost_views;
                    case PINK:
                        ghost_views.add(new TexturePinkGhostEast().getTexture());
                        ghost_views.add(new TexturePinkGhostEast2().getTexture());
                        return ghost_views;
                    case RED:
                        ghost_views.add(new TextureRedGhostEast().getTexture());
                        ghost_views.add(new TextureRedGhostEast2().getTexture());
                        return ghost_views;
                }
            case South:
            case Stop:
                if (!ghost.isAlive()) {
                    ghost_views.add(new TextureDeadGhostSouth().getTexture());
                    return ghost_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        ghost_views.add(new TextureBlueGhostSouth().getTexture());
                        ghost_views.add(new TextureBlueGhostSouth2().getTexture());
                        return ghost_views;
                    case ORANGE:
                        ghost_views.add(new TextureOrangeGhostSouth().getTexture());
                        ghost_views.add(new TextureOrangeGhostSouth2().getTexture());
                        return ghost_views;
                    case PINK:
                        ghost_views.add(new TexturePinkGhostSouth().getTexture());
                        ghost_views.add(new TexturePinkGhostSouth2().getTexture());
                        return ghost_views;
                    case RED:
                        ghost_views.add(new TextureRedGhostSouth().getTexture());
                        ghost_views.add(new TextureRedGhostSouth2().getTexture());
                        return ghost_views;
                }
            case West:
                if (!ghost.isAlive()) {
                    ghost_views.add(new TextureRespawnDeadWest().getTexture());
                    return ghost_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        ghost_views.add(new TextureBlueGhostWest().getTexture());
                        ghost_views.add(new TextureBlueGhostWest2().getTexture());
                        return ghost_views;
                    case ORANGE:
                        ghost_views.add(new TextureOrangeGhostWest().getTexture());
                        ghost_views.add(new TextureOrangeGhostWest2().getTexture());
                        return ghost_views;
                    case PINK:
                        ghost_views.add(new TexturePinkGhostWest().getTexture());
                        ghost_views.add(new TexturePinkGhostWest2().getTexture());
                        return ghost_views;
                    case RED:
                        ghost_views.add(new TextureRedGhostWest().getTexture());
                        ghost_views.add(new TextureRedGhostWest2().getTexture());
                        return ghost_views;
                }
        }
        return null;
    }
}
