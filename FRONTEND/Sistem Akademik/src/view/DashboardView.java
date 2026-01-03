package view;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import service.TugasService;
import util.SceneManager;

public class DashboardView {

    private BorderPane root;

    // ===== DATA DARI SERVICE =====
    private final TugasService tugasService = new TugasService();

    private int doneTask;
    private int totalTask;
    private final int streakDay = 5; // sementara (boleh statis untuk presentasi)

    public DashboardView() {
        // ambil data nyata
        doneTask = tugasService.getJumlahSelesai();
        totalTask = tugasService.getTotalTugas();

        buildUI();
    }

    private void buildUI() {

        // ===== HEADER =====
        Label title = new Label("Dashboard");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        HBox header = new HBox(title);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20));

        // ===== PROGRESS SECTION =====
        VBox progressSection = buildProgressSection();

        // ===== SUMMARY CARDS =====
        HBox cards = new HBox(14,
                createCard("🔥 Streak", streakDay + " Hari"),
                createCard("✔ Today", doneTask + "/" + totalTask),
                createCard("⭐ Level", "Intermediate")
        );
        cards.setAlignment(Pos.CENTER);
        cards.setPadding(new Insets(10));

        // ===== NAVIGATION =====
        Button tasksBtn = new Button("Tasks");
        Button profileBtn = new Button("Profile");

        tasksBtn.setOnAction(e ->
                SceneManager.show(
                        new TasksView().getView(),
                        SceneManager.Anim.SLIDE_LEFT
                )
        );

        profileBtn.setOnAction(e ->
                SceneManager.show(
                        new ProfileView().getView(),
                        SceneManager.Anim.SLIDE_LEFT
                )
        );

        HBox nav = new HBox(20, tasksBtn, profileBtn);
        nav.setAlignment(Pos.CENTER);
        nav.setPadding(new Insets(20));

        VBox content = new VBox(20, progressSection, cards, nav);
        content.setAlignment(Pos.TOP_CENTER);

        root = new BorderPane();
        root.setTop(header);
        root.setCenter(content);
    }

    // ======================================================
    // === PROGRESS HARIAN + STREAK (ANIMATED)
    // ======================================================
    private VBox buildProgressSection() {

        // ---- TODAY PROGRESS ----
        Label todayLabel = new Label("Progress Hari Ini");
        ProgressBar todayBar = new ProgressBar(0);
        todayBar.setPrefWidth(260);

        double todayProgress =
                totalTask == 0 ? 0 : (double) doneTask / totalTask;

        animateProgress(todayBar, todayProgress);

        Label todayText = new Label(
                doneTask + " dari " + totalTask + " tugas selesai"
        );

        VBox todayBox = new VBox(6, todayLabel, todayBar, todayText);
        todayBox.setPadding(new Insets(14));
        todayBox.setStyle("""
            -fx-background-color: #fde7c3;
            -fx-background-radius: 14;
        """);

        // ---- STREAK PROGRESS ----
        Label streakLabel = new Label("Streak Mingguan");
        ProgressIndicator streakIndicator = new ProgressIndicator(0);

        double streakProgress = streakDay / 7.0;
        animateProgress(streakIndicator, streakProgress);

        Label streakText = new Label(streakDay + " / 7 hari");

        VBox streakBox = new VBox(6, streakLabel, streakIndicator, streakText);
        streakBox.setAlignment(Pos.CENTER);
        streakBox.setPadding(new Insets(14));
        streakBox.setStyle("""
            -fx-background-color: #fde7c3;
            -fx-background-radius: 14;
        """);

        HBox wrapper = new HBox(14, todayBox, streakBox);
        wrapper.setAlignment(Pos.CENTER);

        return new VBox(wrapper);
    }

    // ===== ANIMATE PROGRESS (HALUS) =====
    private void animateProgress(ProgressIndicator indicator, double target) {
        Timeline tl = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(indicator.progressProperty(), 0)),
                new KeyFrame(Duration.millis(600),
                        new KeyValue(indicator.progressProperty(), target, Interpolator.EASE_BOTH))
        );
        tl.play();
    }

    // ======================================================
    // === CARD DENGAN ANIMASI (HOVER)
    // ======================================================
    private VBox createCard(String titleText, String valueText) {

        Label title = new Label(titleText);
        Label value = new Label(valueText);
        value.setStyle("-fx-font-weight: bold;");

        VBox card = new VBox(6, title, value);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(16));
        card.setPrefWidth(110);

        card.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 14;
        """);

        DropShadow shadow = new DropShadow(10, Color.rgb(0,0,0,0.15));

        card.setOnMouseEntered(e -> {
            TranslateTransition up =
                    new TranslateTransition(Duration.millis(150), card);
            up.setToY(-6);
            card.setEffect(shadow);
            up.play();
        });

        card.setOnMouseExited(e -> {
            TranslateTransition down =
                    new TranslateTransition(Duration.millis(150), card);
            down.setToY(0);
            card.setEffect(null);
            down.play();
        });

        return card;
    }

    public Parent getView() {
        return root;
    }
}
