package view;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneUtil {

    public static void switchScene(Stage stage, Scene newScene) {
        newScene.getRoot().setOpacity(0);

        stage.setScene(newScene);

        FadeTransition fade = new FadeTransition(Duration.millis(300), newScene.getRoot());
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
}
