package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import util.SceneManager;

public class LoginView {

    private VBox root;

    public LoginView() {
        buildUI();
    }

    private void buildUI() {

        Label title = new Label("EightPlanner");
        title.setStyle("""
            -fx-font-size: 28px;
            -fx-font-weight: bold;
            -fx-text-fill: #2F80ED;
        """);

        TextField username = new TextField();
        username.setPromptText("Username");
        styleField(username);

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        styleField(password);

        Button loginBtn = new Button("Login");
        loginBtn.setPrefWidth(260);
        loginBtn.setStyle("""
            -fx-background-color: #2F80ED;
            -fx-text-fill: white;
            -fx-font-size: 16px;
            -fx-background-radius: 10;
        """);

        loginBtn.setOnAction(e ->
                SceneManager.show(
                        new DashboardView().getView(),
                        SceneManager.Anim.FADE
                )
        );

        root = new VBox(18, title, username, password, loginBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");
    }

    private void styleField(TextField field) {
        field.setPrefWidth(260);
        field.setStyle("""
            -fx-background-radius: 10;
            -fx-border-color: #E0E0E0;
            -fx-padding: 10;
        """);
    }

    public Parent getView() {
        return root;
    }
}
