package gameplay;

import gameplay.Entity;

import java.util.List;

public interface Game {

    void addEntity(Entity entity);
    List<Entity> getEntities();
}
