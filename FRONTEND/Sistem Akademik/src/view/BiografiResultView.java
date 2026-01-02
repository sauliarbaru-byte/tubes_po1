package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BiografiResultView {

    private Scene scene;

    public BiografiResultView(
            Stage stage,
            String nim,
            String nama,
            String alamat,
            String tgl,
            String gender,
            String telp) {

        Button back = new Button("<-- Data Akun");
        back.setOnAction(e ->
            stage.setScene(new ProfileView(stage).getScene())
        );

        VBox card = new VBox(8,
                label("NIM : " + nim),
                label("Nama : " + nama),
                label("Alamat : " + alamat),
                label("Tgl Lahir : " + tgl),
                label("Gender : " + gender),
                label("No Telp : " + telp)
        );

        card.setPadding(new Insets(15));
        card.setStyle("""
            -fx-background-color: #d9c7a3;
            -fx-background-radius: 12;
        """);

        VBox root = new VBox(20, back, card);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fde7c3;");

        scene = new Scene(root, 450, 650);
    }

    private Label label(String text) {
        return new Label(text);
    }

    public Scene getScene() {
        return scene;
    }
}
