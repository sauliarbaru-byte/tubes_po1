package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import util.SceneManager;

public class ProfileView {

    private BorderPane root;

    public ProfileView() {
        buildUI();
    }

    private void buildUI() {

        // ===== NAVBAR (SAMA PERSIS SEMUA VIEW) =====
        TopNavbar navbar = new TopNavbar("profile");

        // ===== HEADER USER =====
        Label name = new Label("UJANG RONDA");
        name.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");

        Label nim = new Label("2250081376");
        nim.setStyle("-fx-text-fill:#666;");

        VBox header = new VBox(6, name, nim);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(24));

        // ===== MENU =====
        VBox menu = new VBox(14,
                item("👨‍🎓 Biografi", () -> BiografiFormView.show()),
                item("🎓 Akademik", () -> AkademikFormView.show()),
                item("🏫 Asal Sekolah", () -> AsalSekolahFormView.show()),
                item("🚪 Logout", () ->
                        SceneManager.show(new LoginView().getView(), SceneManager.Anim.FADE)
                )
        );
        menu.setPadding(new Insets(24));

        VBox content = new VBox(header, menu);
        content.setMaxWidth(900);          // 🔥 PENTING
        content.setAlignment(Pos.TOP_CENTER);

        // ===== WRAPPER BIAR TENGAH & KONSISTEN =====
        StackPane centerWrapper = new StackPane(content);
        centerWrapper.setPadding(new Insets(24));
        centerWrapper.setAlignment(Pos.TOP_CENTER);

        // ===== ROOT =====
        root = new BorderPane();
        root.setTop(navbar);
        root.setCenter(centerWrapper);
    }

    private HBox item(String text, Runnable action) {

        Label l = new Label(text);
        l.setStyle("-fx-font-weight:bold;");

        Label arrow = new Label("›");
        arrow.setStyle("-fx-text-fill:#999;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox box = new HBox(l, spacer, arrow);
        box.setPadding(new Insets(16));
        box.setAlignment(Pos.CENTER_LEFT);
        box.setStyle("""
            -fx-background-color: white;
            -fx-background-radius: 14;
            -fx-border-color: #EEE;
        """);

        box.setOnMouseClicked(e -> action.run());
        return box;
    }

    public Parent getView() {
        return root;
    }
}
