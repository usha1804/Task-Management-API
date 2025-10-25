package com.example.Task.Management.API.model;






import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
@NotBlank(message = "Title is required")
    private String title;
@NotBlank(message = "Description is required") 
 private String description;
 private String status; 
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = null;
        this.updatedAt = null;
    }
}
