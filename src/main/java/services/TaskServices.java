package services;

import cybersoft.java18.crm.model.TaskModel;
import cybersoft.java18.crm.repository.TaskRepository;

import java.util.List;

public class TaskServices {

    private static TaskServices INSTANCE = null;

    private final TaskRepository taskRepository = new TaskRepository();

    public static TaskServices getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskServices();
        }
        return INSTANCE;
    }

    public List<TaskModel> getAllTask() {
        return taskRepository.getAllTask();
    }
}
