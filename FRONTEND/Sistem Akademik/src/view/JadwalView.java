package view;

public package view;

import controller.JadwalController;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class JadwalView {

    private Scene scene;

    public JadwalView() {
        JadwalController controller = new JadwalController();

        TextArea area = new TextArea();
        area.setEditable(false);
        area.setText("Lihat output di console\n(UI versi teks)");

        VBox root = new VBox(area);
        scene = new Scene(root, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
 {
    
}
