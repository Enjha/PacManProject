package Motor;

import Gameplay.Character;
import Gameplay.Entity;
import Gameplay.Movement;
import Scene.*;

public class ClassicMotorPhysic implements MotorPhysic{

    public Collision moveEntity(Movement movement, Scene scene){
        int[] positionEntity = {movement.getEntity().getPosition().getX(),movement.getEntity().getPosition().getY()};
        int[] nextPositionEntity = movement.nextPosition();
        SceneCase sceneCaseEntity = movement.getEntity().getPosition();
        SceneElement sceneElement = scene.obstacle(sceneCaseEntity.getX(),sceneCaseEntity.getY(),movement);

        if(sceneElement != null){
            return new CollisionEntitySceneElement(movement.getEntity(),sceneElement);
        }
        else {
            for(Object object : scene.getCase(nextPositionEntity[0],nextPositionEntity[1]).getCaseContent(Entity.class.toString())){
                Entity entity = (Entity) object;
                if(entity.isCharacter() && movement.getEntity().isCharacter()){
                    if(((Character)entity).getTeam() == ((Character)movement.getEntity()).getTeam()){
                        if(((Character)entity).getTeam().getCollision()){
                            return new CollisionEntities(movement.getEntity(),entity);
                        }
                    }
                    else {
                        return new CollisionEntities(movement.getEntity(),entity);
                    }
                }
            }

        }

        return null;
    }


}
