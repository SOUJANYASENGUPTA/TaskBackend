package com.shreyoshi.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shreyoshi.backend.model.Task;
import com.shreyoshi.backend.service.TaskService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000" ,maxAge =3600)
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all tasks
    @GetMapping("/getAll")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks =  taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Create a new task
    @PostMapping("/add")
    public ResponseEntity<Void> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Get a task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Update a task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

