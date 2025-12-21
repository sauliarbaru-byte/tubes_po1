import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.TugasView;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        TugasView tugasView = new TugasView();
        Scene scene = new Scene(tugasView.getRoot(), 800, 500);
        primaryStage.setTitle("Aplikasi Pengingat Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
