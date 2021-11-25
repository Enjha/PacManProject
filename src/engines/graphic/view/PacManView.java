package engines.graphic.view;

import gameplay.Direction;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

public class PacManView {

    //PACMAN MOOVE
    private final Image pacman_north;
    private final Image pacman_north_open;
    private final Image pacman_east;
    private final Image pacman_east_open;
    private final Image pacman_south;
    private final Image pacman_south_open;
    private final Image pacman_west;
    private final Image pacman_west_open;

    //PACMAN DEAD
    private final Image pacman_dead1;
    private final Image pacman_dead2;
    private final Image pacman_dead3;
    private final Image pacman_dead4;
    private final Image pacman_dead5;
    private final Image pacman_dead6;
    private final Image pacman_dead7;
    private final Image pacman_dead8;
    private final Image pacman_dead9;
    private final Image pacman_dead10;


    private final ArrayList<Image> pacman_north_views;
    private final ArrayList<Image> pacman_east_views;
    private final ArrayList<Image> pacman_south_views;
    private final ArrayList<Image> pacman_west_views;
    private final ArrayList<Image> pacman_dead_views;

    public PacManView() {
        this.pacman_north = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_north.gif")));
        this.pacman_north_open = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_north_open.gif")));
        this.pacman_east = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_east.gif")));
        this.pacman_east_open = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_east_open.gif")));
        this.pacman_south = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_south.gif")));
        this.pacman_south_open = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_south_open.gif")));
        this.pacman_west = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_west.gif")));
        this.pacman_west_open = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_west_open.png")));

        this.pacman_dead1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead1.png")));
        this.pacman_dead2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead2.png")));
        this.pacman_dead3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead3.png")));
        this.pacman_dead4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead4.png")));
        this.pacman_dead5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead5.png")));
        this.pacman_dead6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead6.png")));
        this.pacman_dead7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead7.png")));
        this.pacman_dead8 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead8.png")));
        this.pacman_dead9 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead9.png")));
        this.pacman_dead10 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ressources/textures/pacman/pacman_dead10.png")));

        this.pacman_north_views = new ArrayList<>();
        this.pacman_east_views = new ArrayList<>();
        this.pacman_south_views = new ArrayList<>();
        this.pacman_west_views = new ArrayList<>();
        this.pacman_dead_views = new ArrayList<>();
    }

    public ArrayList<Image> getPacmanView(Direction direction) {
        switch (direction) {
            case North:
                this.pacman_north_views.add(pacman_north);
                this.pacman_north_views.add(pacman_north_open);
                return this.pacman_north_views;
            case East:
                this.pacman_east_views.add(pacman_east);
                this.pacman_east_views.add(pacman_east_open);
                return this.pacman_east_views;
            case South:
                this.pacman_south_views.add(pacman_south);
                this.pacman_south_views.add(pacman_south_open);
                return this.pacman_south_views;
            case West:
                this.pacman_west_views.add(pacman_west);
                this.pacman_west_views.add(pacman_west_open);
                return this.pacman_west_views;
            case Dead:
                this.pacman_dead_views.add(pacman_dead1);
                this.pacman_dead_views.add(pacman_dead2);
                this.pacman_dead_views.add(pacman_dead3);
                this.pacman_dead_views.add(pacman_dead4);
                this.pacman_dead_views.add(pacman_dead5);
                this.pacman_dead_views.add(pacman_dead6);
                this.pacman_dead_views.add(pacman_dead7);
                this.pacman_dead_views.add(pacman_dead8);
                this.pacman_dead_views.add(pacman_dead9);
                this.pacman_dead_views.add(pacman_dead10);
                return this.pacman_dead_views;
        }
        return null;
    }

}
