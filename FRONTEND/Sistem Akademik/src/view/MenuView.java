package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView {

    private Scene scene;

    public MenuView(Stage stage) {
        Button dashboardBtn = new Button("Dashboard");
        Button logoutBtn = new Button("Logout");

        dashboardBtn.setOnAction(e -> {
            DashboardView dashboardView = new DashboardView(stage);
            stage.setScene(dashboardView.getScene());
        });

        logoutBtn.setOnAction(e -> {
            LoginView loginView = new LoginView(stage);
            stage.setScene(loginView.getScene());
        });

        VBox root = new VBox(20, dashboardBtn, logoutBtn);
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
