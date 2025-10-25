package com.example.Task.Management.API.repository;




import com.example.Task.Management.API.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TaskRepository {
    private final Map<Long, Task> taskMap = new HashMap<>();
    private long idCounter = 1;

    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idCounter++);
            task.setCreatedAt(LocalDateTime.now());
        }
        task.setUpdatedAt(LocalDateTime.now());
        taskMap.put(task.getId(), task);
        return task;
    }

    public void deleteById(Long id) {
        taskMap.remove(id);
    }
}
