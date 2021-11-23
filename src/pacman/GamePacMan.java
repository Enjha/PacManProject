package pacman;

import gameplay.Entity;
import gameplay.Game;

import java.util.ArrayList;
import java.util.List;

public class GamePacMan implements Game {

    private List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public List<Entity> getEntities(){
        return entities;
    }
}
