package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.SceneManager;

public class BiografiResultView {

    private VBox root;

    public BiografiResultView(
            String nim,
            String nama,
            String alamat,
            String tgl,
            String gender,
            String telp) {

        Button back = new Button("<-- Data Akun");
        back.setOnAction(e ->
                SceneManager.show(
                        new ProfileView().getView(),
                        SceneManager.Anim.SLIDE_RIGHT
                )
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

        root = new VBox(20, back, card);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fde7c3;");
    }

    private Label label(String text) {
        return new Label(text);
    }

    public Parent getView() {
        return root;
    }
}
