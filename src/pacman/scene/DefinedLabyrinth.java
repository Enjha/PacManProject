package pacman.scene;

import gameplay.Direction;
import pacman.Labyrinth2D;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import scene.SceneCase;
import scene.SceneGame;
import scene.Wall;

public class DefinedLabyrinth implements LabyrinthGenerator{

    public final int height = 28;//28;
    public final int width = 26;//26;

    public SceneGame generateLabyrinth(){
        SceneGame sceneGame = new Labyrinth2D(height,width);

        generateSceneCaseEmpty(sceneGame);
        generateExteriorWall(sceneGame);

        return sceneGame;
    }

    private void generateSceneCaseEmpty(SceneGame sceneGame){
        for(int w = 0; w < width; w ++){
            for(int h = 0; h < height; h ++){
                sceneGame.addSceneCase(new LabyrinthCase(w,h,new NormalCaseContentManager()),w,h);
            }
        }
    }

    private void generateExteriorWall(SceneGame sceneGame){
        SceneCase sceneCase;

        for(int w = 0; w < width; w ++){
            sceneCase = sceneGame.getCase(w,0);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.North));
            }
            else {
                System.out.println("case (" + w +",0) : null");
            }

            sceneCase = sceneGame.getCase(w,height - 1);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.South));
            }
            else {
                System.out.println("case (" + w +"," + (height - 1) + ") : null");
            }
        }

        for(int h = 0; h < height; h ++){
            sceneCase = sceneGame.getCase(0,h);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.West));
            }
            else {
                System.out.println("case (0," + h + ") : null");
            }

            sceneCase = sceneGame.getCase(width - 1,h);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.East));
            }
            else {
                System.out.println("case (" + (width - 1) + "," + h + ") : null");
            }
        }
    }

    private void generateInteriorWall(){

    }
}
