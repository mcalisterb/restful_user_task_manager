package com.application.dao.impl;

import com.application.dao.TaskDao;
import com.application.model.Task;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void update(Task task) {
        entityManager.merge(task);
    }

    @Override
    public Task getTaskById(int id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> getAllTasks(){
        return entityManager.createQuery("Select task from " + Task.class.getSimpleName() + " task").getResultList();
    }

    @Override
    public void delete(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            entityManager.remove(task);
        }
    }


}
