import engines.graphic.GraphicEngine;
import javafx.application.Application;
import javafx.stage.Stage;
import pacman.SceneMainMenu;

public class MainTest extends Application {

    public void start(Stage stage) {

        GraphicEngine graphicEngine = new GraphicEngine(stage);
        graphicEngine.setFxWindow(1200,800,"Pac-Man");
        graphicEngine.setCurrentScene(new SceneMainMenu(stage,graphicEngine));


        //window.openWindow(stage);

        /*VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 300);

        ControlManager controlManager = new ClassicControlManager();
        MotorControl motor = new ClassicMotorControl(scene,controlManager);
        controlManager.addControl(new KeyBoardControl("z", Direction.North));
        controlManager.addControl(new KeyBoardControl("z", Direction.North));
        controlManager.addControl(new KeyBoardControl("d",Direction.East));
        controlManager.addControl(new KeyBoardControl("s",Direction.South));

        SoundManager soundManager = new ClassicSoundManager();
        MotorSound motorSound = new ClassicMotorSound(soundManager);
        soundManager.addSound(new ClassicSound(new MediaPlayer(new Media(new File("ressources/sounds/PacMan/pacman_beginning.wav").toURI().toString())),"credit"));
        motorSound.changeVolume("credit",0.2);
        motorSound.playSound("credit",MediaPlayer.INDEFINITE);

        // cycle infini = MediaPlayer.INDEFINITE


        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
