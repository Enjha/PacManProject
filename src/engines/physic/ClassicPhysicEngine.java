package engines.physic;

import gameplay.Character;
import gameplay.Entity;
import gameplay.Movement;
import scene.*;

import java.util.List;

/**
 * A classic physic engine
 */
public class ClassicPhysicEngine implements PhysicEngine {

    /**
     * Treat the movement of a entity in a scene game and return a collision if its exist or null
     * @param movement
     *      the movement of a entity
     * @param sceneGame
     *      the scene game
     * @return
     */
    public Collision moveEntity(Movement movement, SceneGame sceneGame){
        assert(movement != null && sceneGame != null);

        int[] nextPositionEntity = movement.nextPosition();

        SceneCase sceneCaseEntity = movement.getEntity().getPosition();
        //we search if they is a collision with a scene element
        SceneElement sceneElement = sceneGame.obstacleElement(sceneCaseEntity.getX(),sceneCaseEntity.getY(),movement);

        if(sceneElement != null){
            //a collision with this entity and a scene element
            return new CollisionEntitySceneElement(movement.getEntity(),sceneElement);
        }
        else {
            List<Entity> list = sceneGame.obstacleEntity(nextPositionEntity[0],nextPositionEntity[1]);
            if(list != null) {
                for (Entity entity : list) {
                    if (movement.getEntity().isCharacter()) {
                        if (entity.isCharacter()) {
                            if (((Character) entity).getTeam() == ((Character) movement.getEntity()).getTeam()) {
                                if (((Character) entity).getTeam().getCollision()) {
                                    //a collision with this entity and a other entity who is a character of the same team
                                    return new CollisionEntities(movement.getEntity(), entity);
                                }
                            }
                            else {
                                //a collision with this entity and a other entity who is not is the same team
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        } else {
                            if (entity.isItem()) {
                                //a collision with this entity and a item
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        }
                    }
                }
            }
        }
        //no collision
        return null;
    }
}
