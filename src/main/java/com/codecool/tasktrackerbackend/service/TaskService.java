package com.codecool.tasktrackerbackend.service;

import com.codecool.tasktrackerbackend.model.Task;
import com.codecool.tasktrackerbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

}
