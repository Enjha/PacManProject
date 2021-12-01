package pacman.scene;


import apiUser.SetupScene;
import engines.UI.Control;
import engines.graphic.GraphicEngine;
import gameplay.Entity;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SceneOptionMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private boolean stateSound = true;
    private GraphicEngine graphicEngine;
    private int indexControlEntities = 0;
    private List<Button> listButtonControl = new ArrayList<>();
    private List<Label> listLabelControl = new ArrayList<>();
    private boolean modifyKeyControl = false;
    private Pane pane;

    public SceneOptionMenu(Stage stage, GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
        this.stage = stage;
    }

    public Scene getScene() {
        pane = new AnchorPane();
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Label labelTitle = new Label();
        setupScene.setLabel(labelTitle, "Options", Pos.CENTER, 500, 50, 80, 200, new Font(30), Paint.valueOf("black"), true);

        Slider sliderSoundVolume = new Slider();
        setupScene.setSlider(sliderSoundVolume, 200, 400, 80, 250, 0.0, 1.0, graphicEngine.getVolume(), true);

        Label labelVolume = new Label();
        setupScene.setLabel(labelVolume, "Volume :", Pos.CENTER, 200, 350, 80, 300, new Font(20), Paint.valueOf("black"), true);

        Label labelVolumeLevel = new Label();
        setupScene.setLabel(labelVolumeLevel, "" + (int) (sliderSoundVolume.getValue() * 100), Pos.CENTER, 430, 400, 80, 100, new Font(20), Paint.valueOf("black"), true);

        Button buttonSound = new Button();
        setupScene.setButton(buttonSound, "Son : Activé", Pos.CENTER, 250, 200, 50, 200, new Font(20), true);

        Button buttonReturn = new Button();
        setupScene.setButton(buttonReturn, "retour", Pos.CENTER, 100, 700, 50, 200, new Font(20), true);

        Button buttonDirection;
        Label labelDirection;
        int x = 690;
        int y = 380;
        Entity entity = graphicEngine.getEntities().get(indexControlEntities);
        List<Control> controls = graphicEngine.getControl(entity);

        Button buttonCharacter = new Button();
        setupScene.setButton(buttonCharacter, entity.getEntityName(), Pos.CENTER, 700, 200, 50, 200, new Font(20), true);
        buttonCharacter.setOnMouseClicked((event) -> changeEntityControl(buttonCharacter));

        for (int i = 0; i < controls.size(); i++) {
            buttonDirection = new Button();
            labelDirection = new Label();
            setupScene.setButton(buttonDirection, controls.get(i).getKey(), Pos.CENTER, x, y + 40, 30, 100, new Font(20), true);
            setupScene.setLabel(labelDirection, controls.get(i).getDirection().toString(), Pos.CENTER, x, y, 30, 100, new Font(20), Paint.valueOf("black"), true);
            Button finalButtonDirection = buttonDirection;
            buttonDirection.setOnMouseClicked((event) -> setControl(finalButtonDirection));
            pane.getChildren().addAll(buttonDirection, labelDirection);
            listButtonControl.add(buttonDirection);
            listLabelControl.add(labelDirection);
            x += 120;
            if (i % 2 != 0) {
                y += 100;
                x = 690;
            }
        }

        sliderSoundVolume.valueProperty().addListener(observable -> {
            if (!stateSound) {
                stateSound = true;
                graphicEngine.unmute();
            }
            graphicEngine.setVolume(sliderSoundVolume.getValue());
            labelVolumeLevel.setText("" + (int) (sliderSoundVolume.getValue() * 100));
        });

        buttonSound.setOnMouseClicked((event) -> setStateSound(buttonSound, sliderSoundVolume, labelVolumeLevel));
        buttonReturn.setOnMouseClicked((event) -> setSceneReturn());

        pane.getChildren().addAll(labelTitle, sliderSoundVolume, labelVolumeLevel, labelVolume, buttonSound, buttonReturn, buttonCharacter);
        root.getChildren().add(pane);
        return scene;
    }

    private void setStateSound(Button soundButton, Slider sliderSoundVolume, Label labelVolumeLevel) {
        if (stateSound) {
            stateSound = false;
            soundButton.setText("Son : Désactivé");
            graphicEngine.setVolume(0);
            graphicEngine.mute();

        } else {
            stateSound = true;
            soundButton.setText("Son : Activé");
            graphicEngine.unmute();
        }
    }

    private void setSceneReturn() {
        if(graphicEngine.getCurrentsThreads().get(0).getState() == Thread.State.WAITING){
            notifyAll();
        }
        graphicEngine.setCurrentScene(graphicEngine.getPreviewScene());
    }

    private void changeEntityControl(Button button) {
        indexControlEntities = (indexControlEntities + 1) % graphicEngine.getEntities().size();
        Entity entity = graphicEngine.getEntities().get(indexControlEntities);
        List<Control> controls = graphicEngine.getControl(entity);
        button.setText(entity.getEntityName());

        if (controls == null) {
            System.out.println("erreur : control");
            System.exit(-1);
        }

        for (int i = 0; i < controls.size(); i++) {
            listLabelControl.get(i).setText(controls.get(i).getDirection().toString());
            listButtonControl.get(i).setText(controls.get(i).getKey());
        }
    }

    private void setControl(Button button) {
        modifyKeyControl = true;
        if (modifyKeyControl) {
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent key) {
                    if (graphicEngine.setControl(button.getText(), key.getText())) {
                        button.setText(key.getText());
                        modifyKeyControl = false;
                        scene.setOnKeyPressed(null);
                    }

                }
            });
        }
    }

    public Pane getPanel() {
        return pane;
    }

    public boolean isSceneGame() {
        return false;
    }
}
