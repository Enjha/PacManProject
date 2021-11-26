package engines.graphic.view;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Entity;
import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class PacManView implements View {

    public PacManView() {
    }

    public ArrayList<Image> getView(Object o) {
        Character character = (Character) o;
        switch (character.getDirection()) {
            case North:
                ArrayList<Image> pacman_north_views = new ArrayList<>();
                pacman_north_views.add(new Image(new File("ressources/pacman/pacman_north.gif").toURI().toString()));
                pacman_north_views.add(new Image(new File("ressources/pacman/pacman_north_open.gif").toURI().toString()));
                return pacman_north_views;
            case East:
                ArrayList<Image> pacman_east_views = new ArrayList<>();
                pacman_east_views.add(new Image(new File("ressources/pacman/pacman_east.gif").toURI().toString()));
                pacman_east_views.add(new Image(new File("ressources/pacman/pacman_east_open.gif").toURI().toString()));
                return pacman_east_views;
            case South:
                ArrayList<Image> pacman_south_views = new ArrayList<>();
                pacman_south_views.add(new Image(new File("ressources/pacman/pacman_south.gif").toURI().toString()));
                pacman_south_views.add(new Image(new File("ressources/pacman/pacman_south_open.gif").toURI().toString()));
                return pacman_south_views;
            case West:
                ArrayList<Image> pacman_west_views = new ArrayList<>();
                pacman_west_views.add(new Image(new File("ressources/pacman/pacman_west.gif").toURI().toString()));
                pacman_west_views.add(new Image(new File("ressources/pacman/pacman_west_open.gif").toURI().toString()));
                return pacman_west_views;
            case Stop:
                ArrayList<Image> pacman_stop_views = new ArrayList<>();
                pacman_stop_views.add(new Image(new File("ressources/pacman/pacman_full.gif").toURI().toString()));
                return pacman_stop_views;
            default:
                if (!character.isAlive()) {
                    ArrayList<Image> pacman_dead_views = new ArrayList<>();
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead1.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead2.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead3.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead4.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead5.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead6.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead7.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead8.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead9.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead10.gif").toURI().toString()));
                    pacman_dead_views.add(new Image(new File("ressources/pacman/dead/pacman_dead11.gif").toURI().toString()));
                    return pacman_dead_views;
                }
        }
        return null;
    }

}
