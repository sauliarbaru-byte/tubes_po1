package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import util.SceneManager;

public class ProfileView {

    private BorderPane root;
    private StackPane content;

    // === TAMBAHAN: simpan menu aktif ===
    private Button activeBtn;

    public ProfileView() {
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

        Label title = new Label("Profile");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        HBox header = new HBox(10, backBtn, title);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);

        // ===== SIDE MENU =====
        Button bioBtn = new Button("Biografi");
        Button akadBtn = new Button("Akademik");
        Button asalBtn = new Button("Asal Sekolah");

        // === TAMBAHAN: styling awal menu ===
        for (Button b : new Button[]{bioBtn, akadBtn, asalBtn}) {
            b.setMaxWidth(Double.MAX_VALUE);
            b.setStyle("""
                -fx-background-color: transparent;
                -fx-text-fill: #444;
                -fx-background-radius: 10;
                -fx-padding: 10 14;
            """);
        }

        VBox menu = new VBox(10, bioBtn, akadBtn, asalBtn);
        menu.setPadding(new Insets(20));
        menu.setPrefWidth(150);

        // ===== CONTENT =====
        content = new StackPane();
        content.setPadding(new Insets(20));

        // default view
        content.getChildren().add(new BiografiView().getView());
        setActive(bioBtn); // === TAMBAHAN: default aktif ===

        // ===== MENU ACTION =====
        bioBtn.setOnAction(e -> {
            setActive(bioBtn);
            switchContent(new BiografiView().getView());
        });

        akadBtn.setOnAction(e -> {
            setActive(akadBtn);
            switchContent(new AkademikView().getView());
        });

        asalBtn.setOnAction(e -> {
            setActive(asalBtn);
            switchContent(new AsalSekolahView().getView());
        });

        root = new BorderPane();
        root.setTop(header);
        root.setLeft(menu);
        root.setCenter(content);
    }

    // === TAMBAHAN: menu aktif ===
    private void setActive(Button btn) {
        if (activeBtn != null) {
            activeBtn.setStyle("""
                -fx-background-color: transparent;
                -fx-font-weight: normal;
                -fx-text-fill: #444;
            """);
        }

        btn.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-font-weight: bold;
            -fx-text-fill: #000;
            -fx-background-radius: 10;
        """);

        activeBtn = btn;
    }

    // ===== NESTED TRANSITION (UPGRADE) =====
    private void switchContent(Parent view) {
        if (content.getChildren().isEmpty()) {
            content.getChildren().add(view);
            return;
        }

        Parent current = (Parent) content.getChildren().get(0);
        content.getChildren().add(view);

        view.setOpacity(0);
        view.setTranslateX(20);

        javafx.animation.FadeTransition fadeIn =
                new javafx.animation.FadeTransition(
                        javafx.util.Duration.millis(220), view);
        fadeIn.setToValue(1);

        javafx.animation.TranslateTransition slideIn =
                new javafx.animation.TranslateTransition(
                        javafx.util.Duration.millis(220), view);
        slideIn.setToX(0);

        javafx.animation.FadeTransition fadeOut =
                new javafx.animation.FadeTransition(
                        javafx.util.Duration.millis(180), current);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e ->
                content.getChildren().remove(current));

        new javafx.animation.ParallelTransition(fadeIn, slideIn).play();
        fadeOut.play();
    }

    public Parent getView() {
        return root;
    }
}
