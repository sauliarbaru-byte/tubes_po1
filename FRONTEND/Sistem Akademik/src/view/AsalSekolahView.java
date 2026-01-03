package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AsalSekolahView {

    private VBox root;

    public AsalSekolahView() {
        root = new VBox(10,
                new Label("Sekolah Asal : ..."),
                new Label("Tahun Lulus : ...")
        );
        root.setPadding(new Insets(20));
    }

    public Parent getView() {
        return root;
    }
}
