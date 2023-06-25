package com.shreyoshi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyoshi.backend.model.Task;
import com.shreyoshi.backend.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task != null) {
            task.setId(taskDetails.getId());
            task.setProjectId(taskDetails.getProjectId());
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setAssignedTo(taskDetails.getAssignedTo());
            task.setPriority(taskDetails.getPriority());
            task.setDeadline(taskDetails.getDeadline());
            task.setStatus(taskDetails.getStatus());
            return taskRepository.save(task);
        }

        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
