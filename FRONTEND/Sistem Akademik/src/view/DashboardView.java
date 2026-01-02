// DashboardView.java
package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DashboardView {

    private Scene scene;

    public DashboardView(Stage stage) {

        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: #fde7c3;");

        Label title = new Label("☰ Dashboard");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        HBox stats = new HBox(10,
                statBox("🔥", "Streak"),
                statBox("📈", "IPK"),
                statBox("✅", "Today"),
                statBox("⭐", "Level")
        );

        HBox filter = new HBox(15,
                menuButton("Priority"),
                menuButton("Deadline")
        );

        VBox tasks = new VBox(10,
                taskItem("Selesaikan tugas matematika"),
                taskItem("Siapkan slide presentasi"),
                taskItem("Baca satu BAB buku")
        );

        HBox quickMenu = new HBox(40,
                quickIcon("History"),
                quickIcon("Add kategori"),
                quickIcon("Tasks history")
        );
        quickMenu.setAlignment(Pos.CENTER);

        content.getChildren().addAll(title, stats, filter, tasks, quickMenu);

        // ===== NAVBAR =====
        Button dashboardBtn = new Button("Dashboard");
        Button tasksBtn = new Button("Tasks");
        Button profileBtn = new Button("Profile");

        dashboardBtn.setDisable(true);

        // 🔥 INI PENTING
        profileBtn.setOnAction(e -> {
            stage.setScene(new ProfileView(stage).getScene());
        });

        HBox navbar = new HBox(40, dashboardBtn, tasksBtn, profileBtn);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(12));
        navbar.setStyle("-fx-background-color: #d9c7a3;");

        BorderPane root = new BorderPane();
        root.setCenter(content);
        root.setBottom(navbar);

        scene = new Scene(root, 450, 650);
    }

    private VBox statBox(String icon, String text) {
        Label label = new Label(icon + " " + text);
        VBox box = new VBox(label);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(85, 60);
        box.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 12;
        """);
        return box;
    }

    private Button menuButton(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(150);
        btn.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 12;
        """);
        return btn;
    }

    private HBox taskItem(String text) {
        Label label = new Label("☑ " + text);
        HBox box = new HBox(label);
        box.setPadding(new Insets(10));
        box.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 12;
        """);
        return box;
    }

    private VBox quickIcon(String text) {
        Label label = new Label(text);
        VBox box = new VBox(label);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public Scene getScene() {
        return scene;
    }
}
