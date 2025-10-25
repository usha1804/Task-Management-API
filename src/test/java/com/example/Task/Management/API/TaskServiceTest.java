package com.example.Task.Management.API;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.Task.Management.API.model.Task;
import com.example.Task.Management.API.repository.TaskRepository;
import com.example.Task.Management.API.service.TaskService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTests {

    private TaskRepository repository;
    private TaskService service;

    @BeforeEach
    void setup() {
        repository = new TaskRepository();
        service = new TaskService(repository);
    }

    @Test
    void testCreateAndGetTask() {
        Task task = new Task("Test Task", "Description", "pending");
        Task created = service.createTask(task);

        assertNotNull(created.getId());
        Task fetched = service.getTaskById(created.getId());
        assertEquals("Test Task", fetched.getTitle());
    }

    @Test
    void testMarkTaskAsComplete() {
        Task task = new Task("Task 2", "Desc", "pending");
        Task created = service.createTask(task);

        Task completed = service.markTaskAsComplete(created.getId());
        assertEquals("completed", completed.getStatus());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("Task 3", "Desc", "pending");
        Task created = service.createTask(task);

        service.deleteTask(created.getId());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.getTaskById(created.getId());
        });
        assertTrue(exception.getMessage().contains("not found"));
    }
}
