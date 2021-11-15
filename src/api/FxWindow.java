package api;

import javafx.stage.Stage;

public class FxWindow {

    private static FxWindow instance;

    private FxWindow() {
    }

    public static FxWindow getInstance() {
        if (instance == null) instance = new FxWindow();
        return instance;
    }

    private final Stage window = new Stage();

    public void initWindow(String title) {
        window.setOnCloseRequest(t -> System.out.println("CLOSING"));
        window.setResizable(false);
        window.setTitle(title);
        window.show();
    }

    public void stopWindow() {
        window.close();

    }



}
