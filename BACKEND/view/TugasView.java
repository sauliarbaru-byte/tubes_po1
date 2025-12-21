package view; 

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Tugas;
import service.TugasService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TugasView {

    private final VBox root;
    private final TextField judulField;
    private final TextArea deskripsiField;
    private final DatePicker deadlinePicker;
    private final ComboBox<String> statusCombo;
    private final Button simpanButton;
    private final TableView<Tugas> tabelTugas;
    private final TugasService tugasService;

    public TugasView() {
        tugasService = new TugasService();

        root = new VBox(15);
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("📘 Aplikasi Pengingat Mahasiswa");
        titleLabel.setFont(new Font("Arial", 22));

        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(10);
        formPane.setPadding(new Insets(10));

        judulField = new TextField();
        deskripsiField = new TextArea();
        deskripsiField.setPrefRowCount(3);
        deadlinePicker = new DatePicker(LocalDate.now());
        statusCombo = new ComboBox<>(FXCollections.observableArrayList("BELUM", "SELESAI"));
        statusCombo.setValue("BELUM");

        simpanButton = new Button("Simpan Tugas");
        simpanButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;");

        formPane.add(new Label("Judul:"), 0, 0);
        formPane.add(judulField, 1, 0);
        formPane.add(new Label("Deskripsi:"), 0, 1);
        formPane.add(deskripsiField, 1, 1);
        formPane.add(new Label("Deadline:"), 0, 2);
        formPane.add(deadlinePicker, 1, 2);
        formPane.add(new Label("Status:"), 0, 3);
        formPane.add(statusCombo, 1, 3);
        formPane.add(simpanButton, 1, 4);

        tabelTugas = new TableView<>();
        TableColumn<Tugas, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Tugas, String> judulCol = new TableColumn<>("Judul");
        judulCol.setCellValueFactory(new PropertyValueFactory<>("judul"));
        TableColumn<Tugas, String> deskripsiCol = new TableColumn<>("Deskripsi");
        deskripsiCol.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        TableColumn<Tugas, LocalDateTime> deadlineCol = new TableColumn<>("Deadline");
        deadlineCol.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        TableColumn<Tugas, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        tabelTugas.getColumns().addAll(idCol, judulCol, deskripsiCol, deadlineCol, statusCol);

        refreshTable();
        simpanButton.setOnAction(e -> simpanTugas());
        root.getChildren().addAll(titleLabel, formPane, tabelTugas);
    }

    public VBox getRoot() { return root; }

    private void simpanTugas() {
        try {
            String judul = judulField.getText();
            String deskripsi = deskripsiField.getText();
            LocalDate deadline = deadlinePicker.getValue();
            String status = statusCombo.getValue();

            if (judul.isEmpty() || deskripsi.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Input tidak lengkap", "Judul dan deskripsi wajib diisi!");
                return;
            }

            Tugas tugas = new Tugas();
            tugas.setJudul(judul);
            tugas.setDeskripsi(deskripsi);
            tugas.setDeadline(deadline.atStartOfDay());
            tugas.setStatus(status);

            boolean success = tugasService.tambahTugas(tugas);
            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Berhasil", "Tugas berhasil disimpan!");
                clearForm();
                refreshTable();
            } else {
                showAlert(Alert.AlertType.ERROR, "Gagal", "Terjadi kesalahan saat menyimpan tugas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void refreshTable() {
        try {
            List<Tugas> daftarTugas = tugasService.getSemuaTugas();
            ObservableList<Tugas> data = FXCollections.observableArrayList(daftarTugas);
            tabelTugas.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        judulField.clear();
        deskripsiField.clear();
        deadlinePicker.setValue(LocalDate.now());
        statusCombo.setValue("BELUM");
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
