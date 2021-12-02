package engines.physic;

import gameplay.Character;
import gameplay.Entity;
import gameplay.Movement;
import scene.*;

import java.util.List;

public class ClassicPhysicEngine implements PhysicEngine {

    public Collision moveEntity(Movement movement, SceneGame sceneGame){
        int[] positionEntity = {movement.getEntity().getPosition().getX(),movement.getEntity().getPosition().getY()};
        int[] nextPositionEntity = movement.nextPosition();
        SceneCase sceneCaseEntity = movement.getEntity().getPosition();
        SceneElement sceneElement = sceneGame.obstacleElement(sceneCaseEntity.getX(),sceneCaseEntity.getY(),movement);

        if(sceneElement != null){
            return new CollisionEntitySceneElement(movement.getEntity(),sceneElement);
        }
        else {
            List<Entity> list = sceneGame.obstacleEntity(nextPositionEntity[0],nextPositionEntity[1],movement);
            if(list != null) {
                for (Entity entity : list) {
                    if (movement.getEntity().isCharacter()) {
                        if (entity.isCharacter()) {
                            System.out.println(entity.getClass().getName());
                            if (((Character) entity).getTeam() == ((Character) movement.getEntity()).getTeam()) {
                                if (((Character) entity).getTeam().getCollision()) {
                                    return new CollisionEntities(movement.getEntity(), entity);
                                }
                            }
                            else {
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        } else {
                            if (entity.isItem()) {
                                return new CollisionEntities(movement.getEntity(), entity);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }


}
