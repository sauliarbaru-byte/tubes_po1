// ProfileView.java
package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ProfileView {

    private Scene scene;

    public ProfileView(Stage stage) {

        Button back = new Button("<-- Data Akun");
        back.setOnAction(e -> stage.setScene(new DashboardView(stage).getScene()));

        Label avatar = new Label("👤");
        avatar.setStyle("-fx-font-size: 60px;");

        Label name = new Label("Nama Mahasiswa");
        Label nim = new Label("NIM: 123456789");

        Button bioBtn = menuBtn("👤 Biografi");
        Button akademikBtn = menuBtn("🎓 Akademik");
        Button sekolahBtn = menuBtn("🏫 Asal Sekolah");

        // 🔥 KE BIOGRAFI
        bioBtn.setOnAction(e -> {
            stage.setScene(new BiografiView(stage).getScene());
        });

        VBox root = new VBox(15,
                back,
                avatar,
                name,
                nim,
                bioBtn,
                akademikBtn,
                sekolahBtn
        );

        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #fde7c3;");

        scene = new Scene(root, 450, 650);
    }

    private Button menuBtn(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(280);
        btn.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 12;
            -fx-font-size: 14px;
        """);
        return btn;
    }

    public Scene getScene() {
        return scene;
    }
}
