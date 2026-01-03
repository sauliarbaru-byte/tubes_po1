package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AkademikView {

    private VBox root;

    public AkademikView() {
        root = new VBox(10,
                new Label("Program Studi : ..."),
                new Label("Semester : ..."),
                new Label("IPK : ...")
        );
        root.setPadding(new Insets(20));
    }

    public Parent getView() {
        return root;
    }
}
