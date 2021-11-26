package engines.graphic.view;

import javafx.scene.image.Image;
import pacman.Ghost;

import java.io.File;
import java.util.ArrayList;

public class GhostView implements View {

    public GhostView() {
    }

    // Reste à faire le cas ou pacman a son pouvoir et le fantome est donc dasn un état AFRAID clignotement.
    @Override
    public ArrayList<Image> getView(Object o) {
        Ghost ghost = (Ghost) o;
        ArrayList<Image> pacman_views = new ArrayList<>();
        switch (ghost.getDirection()) {
            case North:
                if (!ghost.isAlive()) {
                    pacman_views.add(new Image(new File("ressources/ghost/afraid/respawn_ghost_north.gif").toURI().toString()));
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_north.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_north_2.gif").toURI().toString()));
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_north.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_north_2.gif").toURI().toString()));
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_north.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_north_2.gif").toURI().toString()));
                        return pacman_views;
                    case RED:
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_north.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_north_2.gif").toURI().toString()));
                        return pacman_views;
                }
            case East:
                if (!ghost.isAlive()) {
                    pacman_views.add(new Image(new File("ressources/ghost/afraid/respawn_ghost_east.gif").toURI().toString()));
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_east.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_east_2.gif").toURI().toString()));
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_east.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_east_2.gif").toURI().toString()));
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_east.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_east_2.gif").toURI().toString()));
                        return pacman_views;
                    case RED:
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_east.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_east_2.gif").toURI().toString()));
                        return pacman_views;
                }
            case South:
                if (!ghost.isAlive()) {
                    pacman_views.add(new Image(new File("ressources/ghost/afraid/respawn_ghost_south.gif").toURI().toString()));
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_south.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_south_2.gif").toURI().toString()));
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_south.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_south_2.gif").toURI().toString()));
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_south.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_south_2.gif").toURI().toString()));
                        return pacman_views;
                    case RED:
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_south.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_south_2.gif").toURI().toString()));
                        return pacman_views;
                }
            case West:
                if (!ghost.isAlive()) {
                    pacman_views.add(new Image(new File("ressources/ghost/afraid/respawn_ghost_west.gif").toURI().toString()));
                    return pacman_views;
                }
                switch (ghost.getColor()) {
                    case BLUE:
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_west.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/blue_ghost/blue_ghost_west_2.gif").toURI().toString()));
                        return pacman_views;
                    case ORANGE:
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_west.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/orange_ghost/orange_ghost_nwest_2.gif").toURI().toString()));
                        return pacman_views;
                    case PINK:
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_west.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/pink_ghost/pink_ghost_west_2.gif").toURI().toString()));
                        return pacman_views;
                    case RED:
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_west.gif").toURI().toString()));
                        pacman_views.add(new Image(new File("ressources/ghost/red_ghost/red_ghost_west_2.gif").toURI().toString()));
                        return pacman_views;
                }
        }
        return null;
    }
}
