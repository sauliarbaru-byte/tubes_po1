package service;

import model.Tugas;
import dao.TugasDAO; // ✅ tambahan penting

public class TugasService {

    private TugasDAO tugasDAO;

    public TugasService() {
        tugasDAO = new TugasDAO();
    }

    public void tambahTugas(Tugas tugas) {
        tugasDAO.tambahTugas(tugas);
    }
}
