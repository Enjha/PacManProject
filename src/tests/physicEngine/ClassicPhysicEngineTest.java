package tests.physicEngine;

import engines.physic.ClassicPhysicEngine;
import engines.physic.Collision;
import engines.physic.PhysicEngine;
import gameplay.*;
import gameplay.Character;
import org.junit.jupiter.api.Test;
import pacman.*;
import scene.SceneCase;
import scene.SceneElement;
import scene.SceneGame;
import scene.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClassicPhysicEngineTest {
    private final PhysicEngine physicEngine = new ClassicPhysicEngine();
    private final SceneGame sceneGame = new Labyrinth2D(3,3);
    private final SceneCase sceneCase1 = new LabyrinthCase(1,1,new NormalCaseContentManager());
    private final SceneCase sceneCase2 = new LabyrinthCase(1,0,new NormalCaseContentManager());
    private final SceneCase sceneCase3 = new LabyrinthCase(1,2,new NormalCaseContentManager());
    private final SceneCase sceneCase4 = new LabyrinthCase(2,1,new NormalCaseContentManager());
    private final TeamManager teamManager = new ClassicTeamManager();
    private final Team team1 = new ClassicTeam("team1",true);
    private final Team team2 = new ClassicTeam("team2",false);
    private Entity entity1 = new Pacman();
    private Entity entity2 = new Pacman();
    private Entity entity3 = new Pacman();
    private SceneElement wall1 = new Wall(Direction.West);

    @Test
    void moveEntity() {
        ((Character)entity1).setTeam(team1);
        ((Character)entity2).setTeam(team1);
        teamManager.addTeam(team1);
        ((Character)entity3).setTeam(team2);
        teamManager.addTeam(team2);

        sceneGame.addSceneCase(sceneCase1,1,1);
        sceneCase1.addCaseContent(wall1);
        sceneCase1.addCaseContent(entity1);
        entity1.setPosition(sceneCase1);

        sceneGame.addSceneCase(sceneCase2,1,0);
        sceneCase2.addCaseContent(entity2);
        entity2.setPosition(sceneCase2);

        sceneGame.addSceneCase(sceneCase3,1,2);
        sceneCase3.addCaseContent(entity3);
        entity3.setPosition(sceneCase3);

        sceneGame.addSceneCase(sceneCase4,2,1);

        //collision between two entity of the same team whit the collision on
        Collision collision = physicEngine.moveEntity(new MovementNorth(entity1),sceneGame);
        assertEquals(entity1,collision.getFirstObjectCollision());
        assertEquals(entity2,collision.getSecondObjectCollision());

        //collision between two entity of the same team whit the collision off
        team1.setCollision(false);
        collision = physicEngine.moveEntity(new MovementNorth(entity1),sceneGame);
        assertNull(collision);

        //collision between two entity in different team
        collision = physicEngine.moveEntity(new MovementSouth(entity1),sceneGame);
        assertEquals(entity1,collision.getFirstObjectCollision());
        assertEquals(entity3,collision.getSecondObjectCollision());

        //collision between a entity and a scene element
        collision = physicEngine.moveEntity(new MovementWest(entity1),sceneGame);
        assertEquals(entity1,collision.getFirstObjectCollision());
        assertEquals(wall1,collision.getSecondObjectCollision());

        //no collision
        collision = physicEngine.moveEntity(new MovementEast(entity1),sceneGame);
        assertNull(collision);
    }
}