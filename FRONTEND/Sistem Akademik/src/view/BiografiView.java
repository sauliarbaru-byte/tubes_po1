// BiografiView.java
package view;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BiografiView {

    private Scene scene;

    public BiografiView(Stage stage) {

        Button back = new Button("<-- Biografi");
        back.setOnAction(e ->
            stage.setScene(new ProfileView(stage).getScene())
        );

        TextField nim = field("NIM");
        TextField nama = field("Nama");
        TextField alamat = field("Alamat");
        DatePicker tgl = new DatePicker();

        RadioButton laki = new RadioButton("Laki-laki");
        RadioButton perempuan = new RadioButton("Perempuan");
        ToggleGroup gender = new ToggleGroup();
        laki.setToggleGroup(gender);
        perempuan.setToggleGroup(gender);

        TextField telp = field("No. Telepon");

        Button simpan = new Button("💾 Simpan");
        simpan.setStyle("""
            -fx-background-color: #cbb892;
            -fx-background-radius: 10;
        """);

        // ✅ INI YANG SEBELUMNYA TIDAK ADA
        simpan.setOnAction(e -> {
            String genderValue =
                    laki.isSelected() ? "Laki-laki" : "Perempuan";

            // pindah ke halaman hasil
            stage.setScene(
                new BiografiResultView(
                    stage,
                    nim.getText(),
                    nama.getText(),
                    alamat.getText(),
                    tgl.getValue() + "",
                    genderValue,
                    telp.getText()
                ).getScene()
            );
        });

        VBox root = new VBox(10,
                back,
                nim, nama, alamat, tgl,
                new HBox(10, laki, perempuan),
                telp,
                simpan
        );

        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fde7c3;");

        scene = new Scene(root, 450, 650);
    }

    private TextField field(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setStyle("-fx-background-radius: 10;");
        return tf;
    }

    public Scene getScene() {
        return scene;
    }
}
