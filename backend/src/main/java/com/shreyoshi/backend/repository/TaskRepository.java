package com.shreyoshi.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shreyoshi.backend.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional methods can be defined here if needed
}
