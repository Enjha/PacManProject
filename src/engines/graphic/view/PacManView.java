package engines.graphic.view;

import javafx.scene.image.Image;
import pacman.Pacman;

import java.io.File;
import java.util.ArrayList;

public class PacManView implements View {

    public PacManView() {
    }

    @Override
    public ArrayList<Image> getView(Object o) {
        Pacman pacman = (Pacman) o;
        ArrayList<Image> pacman_views = new ArrayList<>();
        switch (pacman.getDirection()) {
            case North:
                pacman_views.add(new Image(new File("ressources/pacman/pacman_north.gif").toURI().toString()));
                pacman_views.add(new Image(new File("ressources/pacman/pacman_north_open.gif").toURI().toString()));
                return pacman_views;
            case East:
                pacman_views.add(new Image(new File("ressources/pacman/pacman_east.gif").toURI().toString()));
                pacman_views.add(new Image(new File("ressources/pacman/pacman_east_open.gif").toURI().toString()));
                return pacman_views;
            case South:
                pacman_views.add(new Image(new File("ressources/pacman/pacman_south.gif").toURI().toString()));
                pacman_views.add(new Image(new File("ressources/pacman/pacman_south_open.gif").toURI().toString()));
                return pacman_views;
            case West:
                pacman_views.add(new Image(new File("ressources/pacman/pacman_west.gif").toURI().toString()));
                pacman_views.add(new Image(new File("ressources/pacman/pacman_west_open.gif").toURI().toString()));
                return pacman_views;
            case Stop:
                pacman_views.add(new Image(new File("ressources/pacman/pacman_full.gif").toURI().toString()));
                return pacman_views;
            default:
                if (!pacman.isAlive()) {
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead1.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead2.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead3.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead4.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead5.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead6.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead7.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead8.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead9.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead10.gif").toURI().toString()));
                    pacman_views.add(new Image(new File("ressources/pacman/dead/pacman_dead11.gif").toURI().toString()));
                    return pacman_views;
                }
        }
        return null;
    }

}
