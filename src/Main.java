import gameplay.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import pacman.*;
import pacman.scene.LabyrinthBuild;

public class Main extends Application {

    public void start(Stage stage) {

        stage.setResizable(false);
        Game game = new GamePacMan(new LabyrinthBuild(), new ClassicScore(), new ClassicGameOver(), new ClassicLife(3), 297, new ClassicTeamManager());
        game.generateSceneGame();
        game.createEntity();
        game.startEngine(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
