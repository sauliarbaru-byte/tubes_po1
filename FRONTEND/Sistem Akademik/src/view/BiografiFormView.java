package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import util.SceneManager;

public class BiografiFormView {

    public static void show() {

        TextField nama = new TextField();
        nama.setPromptText("Nama Lengkap");

        TextField alamat = new TextField();
        alamat.setPromptText("Alamat");

        Button simpan = new Button("Simpan");
        simpan.setOnAction(e ->
                SceneManager.show(new ProfileView().getView(), SceneManager.Anim.SLIDE_RIGHT)
        );

        VBox root = new VBox(12, nama, alamat, simpan);
        root.setPadding(new Insets(20));

        SceneManager.show(root, SceneManager.Anim.SLIDE_LEFT);
    }
}
