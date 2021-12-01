package gameplay;

import javafx.scene.image.Image;

import java.util.ArrayList;

public interface Character extends Entity {

    Team getTeam();
    void setTeam(Team team);
    Direction getDirection();
    void setDirection(Direction direction);
    boolean isAlive();
    ArrayList<Image> getTextures();
}
