package com.application.service;

import com.application.model.Task;
import java.util.List;

public interface TaskService {
    void create(Task task);

    List<Task> getAllTasks();

    Task getTaskById(int id);

    void update(Task task);

    void delete(int id);
}
