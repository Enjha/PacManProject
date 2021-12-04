package tests.pacman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import gameplay.*;
import org.junit.jupiter.api.Test;
import pacman.*;
import scene.SceneCase;
import scene.SceneElement;
import scene.SceneGame;
import scene.Wall;

import java.util.List;

class Labyrinth2DTest {
    private final Labyrinth2D labyrinth = new Labyrinth2D(2,2);
    private final SceneCase sceneCase1 = new LabyrinthCase(0,0,new NormalCaseContentManager());
    private final SceneCase sceneCase2 = new LabyrinthCase(0,1,new NormalCaseContentManager());
    private final SceneCase sceneCase3 = new LabyrinthCase(1,0,new NormalCaseContentManager());

    @Test
    void addSceneCase() {
        for(SceneCase[] tableSceneCase : labyrinth.getCases()){
            for(SceneCase sceneCase : tableSceneCase){
                assertNull(sceneCase);
            }
        }

        labyrinth.addSceneCase(sceneCase1,0,0);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length ; j++){
                if(i == 0 && j == 0){
                    assertEquals(sceneCase1,labyrinth.getCases()[i][j]);
                    break;
                }
                assertNull(labyrinth.getCases()[i][j]);
            }
        }

        labyrinth.addSceneCase(sceneCase2,0,1);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length ; j++){
                if(i == 0){
                    if(j == 0) {
                        assertEquals(sceneCase1, labyrinth.getCases()[i][j]);
                        break;
                    }
                    if(j == 1){
                        assertEquals(sceneCase2,labyrinth.getCases()[i][j]);
                        break;
                    }
                }
                assertNull(labyrinth.getCases()[i][j]);
            }
        }

        labyrinth.addSceneCase(sceneCase3,1,0);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length ; j++){
                if(i == 0){
                    if(j == 0) {
                        assertEquals(sceneCase1, labyrinth.getCases()[i][j]);
                        break;
                    }
                    if(j == 1){
                        assertEquals(sceneCase2,labyrinth.getCases()[i][j]);
                        break;
                    }
                }
                if(i == 1){
                    assertEquals(sceneCase3,labyrinth.getCases()[i][j]);
                    break;
                }
                assertNull(labyrinth.getCases()[i][j]);
            }
        }
    }

    @Test
    void removeSceneCase() {
        labyrinth.addSceneCase(sceneCase1,0,0);
        labyrinth.addSceneCase(sceneCase2,0,1);
        labyrinth.addSceneCase(sceneCase3,1,0);

        labyrinth.removeSceneCase(0,0);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length; j++){
                if(i == 0){
                    if(j == 0){
                        assertNull(labyrinth.getCases()[i][j]);
                        break;
                    }
                    if(j == 1){
                        assertEquals(sceneCase2,labyrinth.getCases()[i][j]);
                        break;
                    }
                }
                if( i == 1 && j == 0){
                    assertEquals(sceneCase3,labyrinth.getCases()[i][j]);
                }
            }
        }

        labyrinth.removeSceneCase(1,0);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length; j++){
                if(i == 0 && j == 1){
                    assertEquals(sceneCase2,labyrinth.getCases()[i][j]);
                    break;
                }
                assertNull(labyrinth.getCases()[i][j]);
            }
        }

        labyrinth.removeSceneCase(0,1);
        for(int i = 0; i < labyrinth.getCases().length; i++){
            for(int j = 0; j < labyrinth.getCases()[i].length; j++){
                assertNull(labyrinth.getCases()[i][j]);
            }
        }
    }

    @Test
    void getCase() {
        labyrinth.addSceneCase(sceneCase1,0,0);
        labyrinth.addSceneCase(sceneCase2,0,1);
        labyrinth.addSceneCase(sceneCase3,1,0);

        assertEquals(sceneCase1,labyrinth.getCase(0,0));
        assertEquals(sceneCase2,labyrinth.getCase(0,1));
        assertEquals(sceneCase3,labyrinth.getCase(1,0));
    }

    @Test
    void obstacleElement() {
        Wall wallNorthSceneCase1 = new Wall(Direction.North);
        sceneCase1.addCaseContent(wallNorthSceneCase1);
        labyrinth.addSceneCase(sceneCase1,0,0);
        labyrinth.addSceneCase(sceneCase2,0,1);
        Movement movementNorth = new MovementNorth(new Pacman(new ClassicLife(3)));
        Movement movementSouth = new MovementSouth(new Pacman(new ClassicLife(3)));

        assertEquals(wallNorthSceneCase1,labyrinth.obstacleElement(0,0,movementNorth));
        assertNull(labyrinth.obstacleElement(0,0,movementSouth));
        assertNull(labyrinth.obstacleElement(0,1,movementNorth));
    }

    @Test
    void obstacleEntity(){
        Entity entity1 = new Pacman(new ClassicLife(3));
        sceneCase1.addCaseContent(entity1);
        labyrinth.addSceneCase(sceneCase1,0,0);
        labyrinth.addSceneCase(sceneCase2,0,1);

        assertEquals(1,labyrinth.obstacleEntity(0,0).size());
        assertEquals(entity1,labyrinth.obstacleEntity(0,0).get(0));
        assertNull(labyrinth.obstacleEntity(0,1));
    }
}