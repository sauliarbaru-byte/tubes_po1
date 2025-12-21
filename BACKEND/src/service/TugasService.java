package service;

import dao.TugasDAO;
import model.Tugas;

public class TugasService {

    private TugasDAO tugasDAO;

    public TugasService() {
        tugasDAO = new TugasDAO();
    }

    public void tambahTugas(Tugas tugas) {
        tugasDAO.tambahTugas(tugas);
    }
}
