package api;

import engines.graphic.Colors;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class FxWindow {

    private static FxWindow instance;
    private final Stage window = new Stage();

    private FxWindow() {
    }

    /**
     * On recupère l'instance de la window.
     * @return instance
     */
    public static FxWindow getInstance() {
        if (instance == null)
            instance = new FxWindow();
        return instance;
    }

    /**
     * Initialise la fenêtre de jeu.
     * @param title => titre de la fenêtre
     */
    public void initWindow(String title) {
        window.setOnCloseRequest(t -> System.out.println("CLOSING"));
        window.setResizable(false);
        window.setTitle(title);
        window.show();
    }

    /**
     * Ferme la fenêtre.
     */
    public void stopWindow() {
        window.close();
    }

    /**
     * Raffraichie la window.
     */
    public void refreshWindow() {
        Scene currentScene = getCurrentScene();
        if (currentScene != null)
            currentScene.getWindow();
    }

    /**
     * Affiche une nouvelle scene.
     */
    public void showScene(Scene scene) {
        window.setScene(scene);
        window.show();
    }

    /**
     * Fixe la couleur du bakground de la fenêtre.
     * @param color => couleur
     */
    public void setBackgroundColor(Color color) {
        window.getScene().getRoot().setStyle("-fx-background-color: rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+");");
    }

    /**
     * Recupère la scène courante
     * @return currentScene
     */
    public Scene getCurrentScene() {
        return window.getScene();
    }

    /**
     * Recupère la fenêtre courante.
     * @return window => fenêtre courrante
     */
    public Stage getWindow() {
        return window;
    }
}