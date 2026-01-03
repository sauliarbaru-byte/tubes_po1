package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import util.SceneManager;
import view.LoginView;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {

        // ROOT UTAMA (SATU-SATUNYA)
        StackPane root = new StackPane();

        // SCENE CUMA SATU
        Scene scene = new Scene(root, 450, 650);

        // INIT SCENE MANAGER
        SceneManager.init(root);

        // HALAMAN PERTAMA
        SceneManager.show(
                new LoginView().getView(),
                SceneManager.Anim.FADE
        );

        stage.setTitle("Sistem Akademik");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
