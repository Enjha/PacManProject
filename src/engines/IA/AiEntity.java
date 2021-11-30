package engines.IA;

import gameplay.Entity;
import pacman.Ghost;
import pacman.Pacman;


public class AiEntity {

    private int choice;
    private Entity entity;

    public AiEntity(Entity entity, Ghost ghost, Pacman pacman) {
        this.entity = entity;
        choice = calculateDijkstra(ghost, pacman);
        pickDirection();
    }

    private int calculateDijkstra(Ghost ghost, Pacman pacman) {


        return 1;
    }

    private void pickDirection() {
        switch (choice) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:

                break;
        }
    }


}
