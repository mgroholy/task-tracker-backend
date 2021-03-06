package com.codecool.tasktrackerbackend.service;

import com.codecool.tasktrackerbackend.model.Task;
import com.codecool.tasktrackerbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        try{
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception){
            throw new NoSuchElementException(String.format("No task found with id: %d", id));
        }
    }

    public Task setReminder(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setReminder(!task.isReminder());
            taskRepository.save(task);
            return task;
        } else {
            throw new NoSuchElementException(String.format("No task found with id: %d", id));
        }
    }
}
