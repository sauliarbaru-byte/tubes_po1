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

        // 🔥 NAVIGASI BARU (DUOLINGO STYLE)
        loginBtn.setOnAction(e -> {
            SceneManager.show(
                new DashboardView().getView(),
                SceneManager.Anim.SLIDE_LEFT
            );
        });

        VBox card = new VBox(15, title, emailField, passwordField, loginBtn);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(30));
        card.setStyle("""
            -fx-background-color: #fde7c3;
            -fx-background-radius: 18;
        """);

        root = new VBox(card);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #fde7c3;");
    }

    private void styleField(TextField field) {
        field.setPrefWidth(260);
        field.setStyle("""
            -fx-background-radius: 10;
            -fx-background-color: #d9c7a3;
            -fx-padding: 10;
        """);
    }

    // ✅ INI YANG DIPANGGIL SceneManager
    public Parent getView() {
        return root;
    }
}
