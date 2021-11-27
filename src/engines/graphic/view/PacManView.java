package engines.graphic.view;

import javafx.scene.image.Image;
import pacman.Pacman;
import pacman.texture.pacman.*;
import java.util.ArrayList;

public class PacManView implements View {

    @Override
    public ArrayList<Image> getView(Object object) {
        if(object instanceof Pacman) {
            Pacman pacman = (Pacman) object;
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
                    pacman_views.add(new TexturePacmanFull().getTexture());
                    return pacman_views;
                default:
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
                    }
            }
        }
        return null;
    }

}
