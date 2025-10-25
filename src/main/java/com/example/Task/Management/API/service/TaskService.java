package com.example.Task.Management.API.service;

import org.springframework.stereotype.Service;
import com.example.Task.Management.API.model.Task;
import com.example.Task.Management.API.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    // Get task by ID
    public Task getTaskById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // Create a new task
    public Task createTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new RuntimeException("Title is required");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new RuntimeException("Description is required");
        }
        if (task.getStatus() == null) {
            task.setStatus("pending");  // Default status
        }
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return repo.save(task);
    }

    // Update existing task
    public Task updateTask(Long id, Task updated) {
        Task existing = getTaskById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());
        return repo.save(existing);
    }

    // Delete a task
    public void deleteTask(Long id) {
        Task existing = getTaskById(id);
        repo.deleteById(id);
    }

    // Mark task as complete
    public Task markTaskAsComplete(Long id) {
        Task task = getTaskById(id);
        task.setStatus("completed");
        task.setUpdatedAt(LocalDateTime.now());
        return repo.save(task);
    }
}