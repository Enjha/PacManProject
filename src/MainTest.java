import engines.UI.*;
import gameplay.Direction;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class MainTest extends Application {

    public void start(Stage stage) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 300);

        HashMap<String,Control> controls = new HashMap<>();
        controls.put("z",new KeyBoardControl("z", Direction.North));
        controls.put("q",new KeyBoardControl("q",Direction.West));
        controls.put("d",new KeyBoardControl("d",Direction.East));
        controls.put("s",new KeyBoardControl("s",Direction.South));

        ControlManager controlManager = new ClassicControlManager(controls);
        MotorControl motor = new ClassicMotorControl(scene,controlManager);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
