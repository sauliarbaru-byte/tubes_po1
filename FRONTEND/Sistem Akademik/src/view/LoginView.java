package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginView {

    private Scene scene;

    public LoginView(Stage stage) {

        Label title = new Label("Login");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        styleField(emailField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleField(passwordField);

        Button loginBtn = new Button("Login");
        loginBtn.setPrefWidth(260);
        loginBtn.setStyle("""
            -fx-background-color: #cbb892;
            -fx-font-size: 16px;
            -fx-background-radius: 10;
        """);

        loginBtn.setOnAction(e -> {
            DashboardView dashboard = new DashboardView(stage);
            stage.setScene(dashboard.getScene());
        });

        VBox card = new VBox(15, title, emailField, passwordField, loginBtn);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(30));
        card.setStyle("""
            -fx-background-color: #fde7c3;
            -fx-background-radius: 18;
        """);

        scene = new Scene(new StackPane(card), 450, 650);
    }

    private void styleField(TextField field) {
        field.setPrefWidth(260);
        field.setStyle("""
            -fx-background-radius: 10;
            -fx-background-color: #d9c7a3;
            -fx-padding: 10;
        """);
    }

    public Scene getScene() {
        return scene;
    }
}
