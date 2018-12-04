package com.application.service.impl;

import com.application.dao.TaskDao;
import com.application.model.Task;
import com.application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void create(Task task) {
        taskDao.create(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskDao.getAllTasks();
    }

    @Override
    public Task getTaskById(int id){
        return taskDao.getTaskById(id);
    }

    @Override
    public void update(Task task) {
        taskDao.update(task);
    }

    @Override
    public void delete(int id){
        taskDao.delete(id);
    }
}
