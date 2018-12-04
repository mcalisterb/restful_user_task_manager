package com.application.dao;

import com.application.model.Task;
import java.util.List;

public interface TaskDao {
    void create(Task task);

    void update(Task task);

    Task getTaskById(int id);

    List<Task> getAllTasks();

    void delete(int id);
}
