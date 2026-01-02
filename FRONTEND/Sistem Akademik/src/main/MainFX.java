package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.LoginView;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sistem Akademik");
        LoginView login = new LoginView(stage);
        stage.setScene(login.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
