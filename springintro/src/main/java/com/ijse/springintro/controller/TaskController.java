package com.ijse.springintro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springintro.Entity.Task; // Import Task
import com.ijse.springintro.service.TaskService;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;


    //endpoints
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getTasksList();
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody Task task) {

        if(task.getTaskName() == null || task.getTaskName() == ""){
            //return error
            return "Please enter a valid task name";
        }

        if(task.getTaskName() == null){
            //return error
            return "Please enter a valid number for priority";
        }

        
        taskService.createTask(task) ;
        return "Task Added succesfully";
    }
}
