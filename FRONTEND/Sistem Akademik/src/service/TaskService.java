package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Selesaikan tugas matematika"));
        tasks.add(new Task("Siapkan slide presentasi"));
        tasks.add(new Task("Baca satu BAB buku"));
        return tasks;
    }
}
