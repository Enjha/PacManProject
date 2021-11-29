package engines.graphic.view;

import javafx.scene.image.Image;
import pacman.Ghost;
import pacman.texture.ghosts.*;

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
        ArrayList<Image> pacman_views = new ArrayList<>();
        switch (ghost.getDirection()) {
            case North:
                if (!ghost.isAlive()) {
                    pacman_views.add(new TextureRespawnGhostNorth().getTexture());
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new TextureBlueGhostNorth().getTexture());
                        pacman_views.add(new TextureBlueGhostNorth2().getTexture());
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new TextureOrangeGhostNorth().getTexture());
                        pacman_views.add(new TextureOrangeGhostNorth2().getTexture());
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new TexturePinkGhostNorth().getTexture());
                        pacman_views.add(new TexturePinkGhostNorth2().getTexture());
                        return pacman_views;
                    case RED:
                        pacman_views.add(new TextureRedGhostNorth().getTexture());
                        pacman_views.add(new TextureRedGhostNorth2().getTexture());
                        return pacman_views;
                }
            case East:
                if (!ghost.isAlive()) {
                    pacman_views.add(new TextureRespawnGhostEast().getTexture());
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new TextureBlueGhostEast().getTexture());
                        pacman_views.add(new TextureBlueGhostEast2().getTexture());
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new TextureOrangeGhostEast().getTexture());
                        pacman_views.add(new TextureOrangeGhostEast2().getTexture());
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new TexturePinkGhostEast().getTexture());
                        pacman_views.add(new TexturePinkGhostEast2().getTexture());
                        return pacman_views;
                    case RED:
                        pacman_views.add(new TextureRedGhostEast().getTexture());
                        pacman_views.add(new TextureRedGhostEast2().getTexture());
                        return pacman_views;
                }
            case South:
            case Stop:
                if (!ghost.isAlive()) {
                    pacman_views.add(new TextureRespawnGhostSouth().getTexture());
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new TextureBlueGhostSouth().getTexture());
                        pacman_views.add(new TextureBlueGhostSouth2().getTexture());
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new TextureOrangeGhostSouth().getTexture());
                        pacman_views.add(new TextureOrangeGhostSouth2().getTexture());
                        return pacman_views;
                    case PINK:
                        System.out.println("test");
                        pacman_views.add(new TexturePinkGhostSouth().getTexture());
                        pacman_views.add(new TexturePinkGhostSouth2().getTexture());
                        return pacman_views;
                    case RED:
                        pacman_views.add(new TextureRedGhostSouth().getTexture());
                        pacman_views.add(new TextureRedGhostSouth2().getTexture());
                        return pacman_views;
                }
            case West:
                if (!ghost.isAlive()) {
                    pacman_views.add(new TextureRespawnGhostWest().getTexture());
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new TextureBlueGhostWest().getTexture());
                        pacman_views.add(new TextureBlueGhostWest2().getTexture());
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new TextureOrangeGhostWest().getTexture());
                        pacman_views.add(new TextureOrangeGhostWest2().getTexture());
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new TexturePinkGhostWest().getTexture());
                        pacman_views.add(new TexturePinkGhostWest2().getTexture());
                        return pacman_views;
                    case RED:
                        pacman_views.add(new TextureRedGhostWest().getTexture());
                        pacman_views.add(new TextureRedGhostWest2().getTexture());
                        return pacman_views;
                }
        }
        return null;
    }
}
