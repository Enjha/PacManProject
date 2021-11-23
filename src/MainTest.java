import engines.UI.*;
import engines.graphic.GraphicEngine;
import engines.kernel.ClassicKernelEngine;
import engines.kernel.KernelEngine;
import engines.sound.ClassicMotorSound;
import engines.sound.ClassicSoundManager;
import engines.sound.MotorSound;
import engines.sound.SoundManager;
import gameplay.Character;
import gameplay.Direction;
import gameplay.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import pacman.*;
import scene.Wall;

public class MainTest extends Application {

    public void start(Stage stage) {

        Game game = new GamePacMan();

        Pacman pacman = new Pacman();
        Ghost ghost = new Ghost("Pinky");

        game.addEntity(pacman);
        game.addEntity(ghost);
        KernelEngine kernelEngine = new ClassicKernelEngine(game);

        GraphicEngine graphicEngine = new GraphicEngine(stage,kernelEngine);
        SoundManager soundManager = new ClassicSoundManager();

        MotorSound motorSound = new ClassicMotorSound(soundManager);

        kernelEngine.setMotorSound(motorSound);
        graphicEngine.setFxWindow(1200,800,"Pac-Man");
        graphicEngine.setCurrentScene(new SceneMainMenu(stage,graphicEngine));

        kernelEngine.setGraphicEngine(graphicEngine);

        ControlManager controlManager = new ClassicControlManager();
        controlManager.addControl(new KeyBoardControl("z",Direction.North,pacman));
        controlManager.addControl(new KeyBoardControl("s",Direction.South,pacman));
        controlManager.addControl(new KeyBoardControl("q",Direction.West,pacman));
        controlManager.addControl(new KeyBoardControl("d",Direction.East,pacman));

        controlManager.addControl(new KeyBoardControl("o",Direction.North,ghost));
        controlManager.addControl(new KeyBoardControl("l",Direction.South,ghost));
        controlManager.addControl(new KeyBoardControl("k",Direction.West,ghost));
        controlManager.addControl(new KeyBoardControl("m",Direction.East,ghost));

        MotorControl motorControl = new ClassicMotorControl(kernelEngine.getCurrentScene(),controlManager);

        kernelEngine.setMotorControl(motorControl);

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
