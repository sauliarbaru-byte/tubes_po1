package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import util.SceneManager;

public class TasksView {

    private BorderPane root;

    public TasksView() {
        buildUI();
    }

    private void buildUI() {

        // ================= NAVBAR ATAS =================
        HBox navBar = new HBox(30,
                navItem("🏠 Dashboard", () ->
                        SceneManager.show(
                                new DashboardView().getView(),
                                SceneManager.Anim.SLIDE_RIGHT
                        )
                ),
                navItem("📋 Tasks", null),
                navItem("👤 Profile", () ->
                        SceneManager.show(
                                new ProfileView().getView(),
                                SceneManager.Anim.SLIDE_LEFT
                        )
                )
        );
        navBar.setAlignment(Pos.CENTER_RIGHT);
        navBar.setPadding(new Insets(14));
        navBar.setStyle("-fx-background-color:#2F8F83;");

        Label title = new Label("EightPlanner");
        title.setStyle("-fx-text-fill:white;-fx-font-size:16px;-fx-font-weight:bold;");

        BorderPane top = new BorderPane();
        top.setLeft(title);
        top.setRight(navBar);
        top.setPadding(new Insets(0,20,0,20));
        top.setStyle("-fx-background-color:#2F8F83;");

        // ================= TASK LIST =================
        VBox tasks = new VBox(14,
                taskItem("Kerjakan Laporan Basis Data", "Deadline: 20 Okt"),
                taskItem("Presentasi PBO", "Deadline: 22 Okt"),
                taskItem("Resume Jaringan Komputer", "Deadline: 25 Okt")
        );
        tasks.setPadding(new Insets(20));

        root = new BorderPane();
        root.setTop(top);
        root.setCenter(tasks);
    }

    private HBox taskItem(String title, String subtitle) {

        Label check = new Label("☐");
        check.setStyle("-fx-font-size:16px;");

        Label t = new Label(title);
        t.setStyle("-fx-font-weight:bold;");

        Label sub = new Label(subtitle);
        sub.setStyle("-fx-text-fill:#666;");

        VBox info = new VBox(4, t, sub);

        HBox box = new HBox(12, check, info);
        box.setPadding(new Insets(14));
        box.setStyle("""
            -fx-background-color:white;
            -fx-background-radius:14;
            -fx-border-color:#EEE;
        """);

        box.setOnMouseClicked(e ->
                check.setText(check.getText().equals("☐") ? "☑" : "☐")
        );

        box.setOnMouseEntered(e ->
                box.setStyle(box.getStyle() + "-fx-effect:dropshadow(gaussian,rgba(0,0,0,0.15),10,0,0,5);")
        );
        box.setOnMouseExited(e ->
                box.setStyle(box.getStyle().replaceAll("-fx-effect:.*?;", ""))
        );

        return box;
    }

    private Label navItem(String text, Runnable action) {
        Label l = new Label(text);
        l.setStyle("-fx-text-fill:white;-fx-font-weight:bold;");
        if (action != null) {
            l.setOnMouseClicked(e -> action.run());
        }
        return l;
    }

    public Parent getView() {
        return root;
    }
}
