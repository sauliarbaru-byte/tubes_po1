package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import util.SceneManager;

public class BiografiFormView {

    private VBox root;

    public BiografiFormView() {

        root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fde7c3;");

        Button back = new Button("<-- Biografi");
        back.setOnAction(e ->
                SceneManager.show(
                        new ProfileView().getView(),
                        SceneManager.Anim.SLIDE_RIGHT
                )
        );

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

        // ===== SIMPAN & PINDAH VIEW =====
        simpan.setOnAction(e -> {
            String gender =
                    laki.isSelected() ? "Laki-laki" :
                    perempuan.isSelected() ? "Perempuan" : "-";

            SceneManager.show(
                    new BiografiResultView(
                            nim.getText(),
                            nama.getText(),
                            alamat.getText(),
                            tgl.getText(),
                            gender,
                            telp.getText()
                    ).getView(),
                    SceneManager.Anim.SLIDE_LEFT
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

    public Parent getView() {
        return root;
    }
}
