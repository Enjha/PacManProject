package Motor;

import Gameplay.Movement;
import Scene.*;

public class ClassicMotorPhysic implements MotorPhysic{

    public Collision moveEntity(Movement movement, Scene scene){
        int[] positionEntity = {movement.getEntity().getPosition().getX(),movement.getEntity().getPosition().getY()};
        int[] nextPositionEntity = movement.nextPosition();
        SceneCase sceneCaseEntity = movement.getEntity().getPosition();

        if(scene.obstacle(sceneCaseEntity.getX(),sceneCaseEntity.getY(),movement)){
            //return new CollisionEntitySceneElement(movement.getEntity(),);
        }

        return null;
    }
}
