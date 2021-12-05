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
     * Treat the movement of a entity in a scene game
     * @param movement
     *      the movement of a entity
     * @param sceneGame
     *      the scene game
     * @return a object type of Collision
     */
    public Collision moveEntity(Movement movement, SceneGame sceneGame) {
        assert movement != null : "Error : movement null";
        assert sceneGame != null : "Error : scene game null";

        int[] nextPositionEntity = movement.nextPosition();
        SceneCase sceneCaseEntity = movement.getEntity().getPosition();
        SceneElement sceneElement = sceneGame.obstacleElement(sceneCaseEntity.getX(), sceneCaseEntity.getY(), movement);

        if (sceneElement != null) {
            //A collision between a entity and a scene element
            //System.out.println("COLLISION CONTRE MUR");
            return new CollisionEntitySceneElement(movement.getEntity(), sceneElement);
        }
        else {
            List<Entity> list = sceneGame.obstacleEntity(nextPositionEntity[0], nextPositionEntity[1]);
            if (list != null) {
                for (Entity entity : list) {
                    if (movement.getEntity().isCharacter()) {
                        if (entity.isCharacter()) {
                            if (((Character) entity).getTeam() == ((Character) movement.getEntity()).getTeam()) {
                                if (((Character) entity).getTeam().getCollision()) {
                                    //A collision between two entity of the same team and with the team's collision on
                                    return new CollisionEntities(movement.getEntity(), entity);
                                }
                            } else {
                                //A collision between two entity of different team
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        } else {
                            if (entity.isItem()) {
                                //A collision between a entity and a item
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        }
                    }
                }
            }
        }
        //No collision
        return null;
    }
}
