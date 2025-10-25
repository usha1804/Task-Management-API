package com.example.Task.Management.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Task.Management.API")
public class TaskManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApiApplication.class, args);
	}

}
