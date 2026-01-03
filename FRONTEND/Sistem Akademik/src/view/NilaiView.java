package view;

import controller.NilaiController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NilaiView {

    private Scene scene;

    public NilaiView() {
        NilaiController controller = new NilaiController();

        Button lihat = new Button("Lihat IPK");
        lihat.setOnAction(e -> controller.tampilkanIPK());

        VBox root = new VBox(20, lihat);
        scene = new Scene(root, 500, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
