package engines.graphic;

import pacman.Labyrinth2D;
import scene.SceneCase;
import scene.Wall;

import java.util.List;

public class LabyrinthGraphic {

    private final SceneCase[][] labyrinth;

    public LabyrinthGraphic(Labyrinth2D labyrinth2D) {
        this.labyrinth = labyrinth2D.getLabyrinth();
    }

    public void setLabyrinthTexture() {
        for (SceneCase[] sceneCases : labyrinth) {
            for (SceneCase sceneCase : sceneCases) {
                List<Object> listwall = sceneCase.getCaseContent(Wall.class.toString());
                for (Object w : listwall) {
                    Wall wall = (Wall) w;
                    /**
                     * RESTE A FAIRE L'AFFECTION DES TEXTURES !
                     */
                    switch (wall.getSceneElement()) {
                        case North:

                            break;
                        case East:

                            break;
                        case South:

                            break;
                        case West:

                            break;
                    }
                }
            }
        }
    }

}
