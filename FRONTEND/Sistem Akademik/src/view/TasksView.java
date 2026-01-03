package view;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.Duration;
import model.Tugas;
import service.TugasService;
import storage.TugasStorage;
import util.SceneManager;

public class TasksView {

    private BorderPane root;
    private final TugasService service = new TugasService();

    public TasksView() {
        buildUI();
    }

    private void buildUI() {

        // ===== HEADER =====
        Button backBtn = new Button("←");
        backBtn.setOnAction(e ->
                SceneManager.show(
                        new DashboardView().getView(),
                        SceneManager.Anim.SLIDE_RIGHT
                )
        );

        Label title = new Label("Tasks");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        HBox header = new HBox(10, backBtn, title);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20));

        // ===== TASK LIST =====
        VBox list = new VBox(12);
        list.setPadding(new Insets(20));

        for (Tugas t : TugasStorage.getSemua()) {
            list.getChildren().add(createTaskItem(t));
        }

        root = new BorderPane();
        root.setTop(header);
        root.setCenter(list);
    }

    // ===== CHECKLIST ITEM =====
    private HBox createTaskItem(Tugas tugas) {

        Label checkbox = new Label(tugas.isSelesai() ? "☑" : "☐");
        Label nama = new Label(tugas.getNama());
        Label status = new Label(new TugasService().getStatus(tugas));

        VBox info = new VBox(2, nama, status);

        HBox box = new HBox(12, checkbox, info);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(12));
        box.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 10;
        """);

        box.setOnMouseClicked(e -> {
            tugas.toggleSelesai();
            checkbox.setText(tugas.isSelesai() ? "☑" : "☐");
            playPop(box);
        });

        return box;
    }

    private void playPop(Region node) {
        ScaleTransition pop = new ScaleTransition(Duration.millis(140), node);
        pop.setFromX(0.96);
        pop.setFromY(0.96);
        pop.setToX(1);
        pop.setToY(1);
        pop.setInterpolator(Interpolator.EASE_OUT);
        pop.play();
    }

    public Parent getView() {
        return root;
    }
}
