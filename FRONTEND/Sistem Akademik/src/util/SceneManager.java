package util;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneManager {

    private static Stage stage;

    public static void init(Stage s) {
        stage = s;
        stage.setTitle("EightPlanner");
    }

    public static void show(Scene scene) {
        stage.setScene(scene);
        stage.show();

        FadeTransition ft = new FadeTransition(Duration.millis(250), scene.getRoot());
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
}
