package com.codecool.tasktrackerbackend.repository;

import com.codecool.tasktrackerbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
