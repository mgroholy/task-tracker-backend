package com.codecool.tasktrackerbackend.controller;

import com.codecool.tasktrackerbackend.model.Task;
import com.codecool.tasktrackerbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping(path = "")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id){
        taskService.deleteTask(id);
    }

}
