package view;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class DashboardView {

    private BorderPane root;
    private ProgressBar progress;
    private Label info;
    private Label streakLabel;

    private final int totalMatkul = 3;
    private int hadirCount = 0;
    private int streak = 0;
    private boolean streakDicatat = false;

    public DashboardView() {
        buildUI();
    }

    private void buildUI() {

        TopNavbar navbar = new TopNavbar("dashboard");

        Label ipkTitle = new Label("IPK Terakhir");
        Label ipk = new Label("3.80");
        ipk.setStyle("-fx-font-size:26px;-fx-font-weight:bold;");

        VBox ipkCard = card(ipkTitle, ipk);

        Label streakTitle = new Label("Streak Kehadiran");
        streakLabel = new Label("🔥 0 Hari");
        streakLabel.setStyle("-fx-font-size:22px;-fx-font-weight:bold;");

        VBox streakCard = card(streakTitle, streakLabel);

        Label absTitle = new Label("Absensi Hari Ini");
        info = new Label("0 dari 3 mata kuliah hadir");

        progress = new ProgressBar(0);
        progress.setPrefWidth(Double.MAX_VALUE);

        VBox absensiCard = new VBox(10, absTitle, info, progress);
        absensiCard.setPadding(new Insets(20));
        absensiCard.setStyle("""
            -fx-background-color:#F1F8FF;
            -fx-background-radius:18;
        """);

        VBox list = new VBox(14,
                absensiItem("Pemrograman Objek", "08.00 - 09.40"),
                absensiItem("Basis Data", "10.00 - 11.40"),
                absensiItem("Jaringan Komputer", "13.00 - 14.40")
        );

        VBox content = new VBox(20, ipkCard, streakCard, absensiCard, list);
        content.setMaxWidth(900);
        content.setAlignment(Pos.TOP_CENTER);

        StackPane center = new StackPane(content);
        center.setPadding(new Insets(24));

        root = new BorderPane();
        root.setTop(navbar);
        root.setCenter(center);
    }

    private VBox card(Label title, Label value) {
        VBox box = new VBox(6, title, value);
        box.setPadding(new Insets(20));
        box.setStyle("""
            -fx-background-color:white;
            -fx-background-radius:18;
            -fx-border-color:#EEE;
        """);
        return box;
    }

    private HBox absensiItem(String matkul, String jam) {

        CheckBox cb = new CheckBox();

        VBox infoBox = new VBox(
                new Label(matkul),
                new Label(jam)
        );
        infoBox.getChildren().get(0).setStyle("-fx-font-weight:bold;");
        infoBox.getChildren().get(1).setStyle("-fx-text-fill:#666;");

        HBox box = new HBox(14, cb, infoBox);
        box.setPadding(new Insets(16));
        box.setAlignment(Pos.CENTER_LEFT);
        box.setStyle("""
            -fx-background-color:white;
            -fx-background-radius:14;
            -fx-border-color:#EEE;
        """);

        cb.setOnAction(e -> {
            hadirCount += cb.isSelected() ? 1 : -1;
            updateProgress();
        });

        return box;
    }

    private void updateProgress() {

        progress.setProgress((double) hadirCount / totalMatkul);
        info.setText(hadirCount + " dari " + totalMatkul + " mata kuliah hadir");

        if (hadirCount == totalMatkul && !streakDicatat) {
            streak++;
            streakLabel.setText("🔥 " + streak + " Hari");
            streakDicatat = true;

            ScaleTransition pop = new ScaleTransition(Duration.millis(200), streakLabel);
            pop.setFromX(0.9);
            pop.setFromY(0.9);
            pop.setToX(1);
            pop.setToY(1);
            pop.play();
        }

        if (hadirCount < totalMatkul) {
            streakDicatat = false;
        }
    }

    public Parent getView() {
        return root;
    }
}
