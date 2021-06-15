package com.codecool.tasktrackerbackend;

import com.codecool.tasktrackerbackend.model.Task;
import com.codecool.tasktrackerbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class TaskTrackerBackendApplication {

    private TaskRepository taskRepository;

    @Autowired
    public TaskTrackerBackendApplication(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerBackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner init(){
        return args -> {
            Task task1 = Task.builder().id(1L).text("Doctors Appointment").day(LocalDateTime.of(2021, 5, 5, 14, 30)).reminder(true).build();
            Task task2 = Task.builder().id(2L).text("Meeting at School").day(LocalDateTime.of(2021, 5, 6, 13, 30)).reminder(true).build();
            Task task3 = Task.builder().id(3L).text("Food Shopping").day(LocalDateTime.of(2021, 5, 6, 12, 30)).reminder(false).build();
            taskRepository.saveAll(Arrays.asList(task1, task2, task3));
        };
    }

}
