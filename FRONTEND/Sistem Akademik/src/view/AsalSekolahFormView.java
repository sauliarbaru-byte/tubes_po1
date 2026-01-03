package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import util.SceneManager;

public class AsalSekolahFormView {

    public static void show() {

        ComboBox<String> jenis = new ComboBox<>();
        jenis.getItems().addAll("SMA", "SMK", "MA");
        jenis.setPromptText("Jenis Sekolah");

        TextField namaSekolah = new TextField();
        namaSekolah.setPromptText("Nama Sekolah Asal");

        DatePicker tglLulus = new DatePicker();
        tglLulus.setPromptText("Tanggal Lulus");

        Button simpan = new Button("Simpan");
        simpan.setOnAction(e ->
                SceneManager.show(
                        new ProfileView().getView(),
                        SceneManager.Anim.SLIDE_RIGHT
                )
        );

        VBox root = new VBox(14,
                jenis,
                namaSekolah,
                tglLulus,
                simpan
        );

        root.setPadding(new Insets(20));

        SceneManager.show(root, SceneManager.Anim.SLIDE_LEFT);
    }
}
