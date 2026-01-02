package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BiografiFormView {

    private Scene scene;

    public BiografiFormView(Stage stage) {

        VBox root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fde7c3;");

        Button back = new Button("<-- Biografi");

        TextField nim = field("NIM");
        TextField nama = field("Nama");
        TextField alamat = field("Alamat");
        TextField tgl = field("Tanggal Lahir");
        TextField telp = field("No. Telepon");

        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton laki = new RadioButton("Laki-laki");
        RadioButton perempuan = new RadioButton("Perempuan");
        laki.setToggleGroup(genderGroup);
        perempuan.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(20, laki, perempuan);

        Button simpan = new Button("💾 Simpan");

        // 👉 PENTING: PINDAH KE SCENE BARU
        simpan.setOnAction(e -> {
            String gender =
                    laki.isSelected() ? "Laki-laki" :
                    perempuan.isSelected() ? "Perempuan" : "-";

            stage.setScene(
                    new BiografiResultView(
                            stage,
                            nim.getText(),
                            nama.getText(),
                            alamat.getText(),
                            tgl.getText(),
                            gender,
                            telp.getText()
                    ).getScene()
            );
        });

        root.getChildren().addAll(
                back,
                nim,
                nama,
                alamat,
                tgl,
                genderBox,
                telp,
                simpan
        );

        scene = new Scene(root, 450, 650);
    }

    private TextField field(String hint) {
        TextField tf = new TextField();
        tf.setPromptText(hint);
        tf.setStyle("""
            -fx-background-radius: 10;
            -fx-padding: 8;
        """);
        return tf;
    }

    public Scene getScene() {
        return scene;
    }
}
