package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import util.SceneManager;

public class AkademikFormView {

    public static void show() {

        TextField prodi = new TextField();
        prodi.setPromptText("Program Studi");

        DatePicker tglMasuk = new DatePicker();
        tglMasuk.setPromptText("Tanggal Masuk");

        TextField angkatan = new TextField();
        angkatan.setPromptText("Angkatan");

        TextField jenjang = new TextField();
        jenjang.setPromptText("Jenjang");

        TextField kurikulum = new TextField();
        kurikulum.setPromptText("Kurikulum");

        Button simpan = new Button("Simpan");
        simpan.setOnAction(e ->
                SceneManager.show(
                        new ProfileView().getView(),
                        SceneManager.Anim.SLIDE_RIGHT
                )
        );

        VBox root = new VBox(14,
                prodi,
                tglMasuk,
                angkatan,
                jenjang,
                kurikulum,
                simpan
        );

        root.setPadding(new Insets(20));

        SceneManager.show(root, SceneManager.Anim.SLIDE_LEFT);
    }
}
