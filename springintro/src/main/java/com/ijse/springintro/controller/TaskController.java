package com.ijse.springintro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springintro.Entity.Task; // Import Task
import com.ijse.springintro.service.TaskService;
import com.ijse.springintro.dto.Responcedto;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;


    //endpoints
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> taskList =taskService.getTasksList();
        
        return ResponseEntity.status(200).body(taskList);
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody Task task) {

        if(task.getTaskName() == null || task.getTaskName() == ""){
            //return error
            return ResponseEntity.status(422).body("Please Enter a valid Task name");
        }

        if(task.getTaskName() == null){
            //return error
            return ResponseEntity.status(422).body("Please enter a valid number for priority");
        }

        
        taskService.createTask(task) ;
        return ResponseEntity.status(201).body("Task Added succesfully");
    }

    @GetMapping("/tasks/{taskId}")  //added path variable to fetch id from client id
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){  //can multiple path add in this way
        Task task = taskService.geTaskByID(taskId);

        if(task == null ){
            return ResponseEntity.status(404).body(null);
        }

        else {
            return ResponseEntity.status(200).body(task);
        }
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task){
        Task updateTask = taskService.updateTask(taskId, task);

        if(updateTask == null){
            return ResponseEntity.status(404).body(null);
        }
        else{
            return ResponseEntity.status(200).body(updateTask);
        }
    }

    @DeleteMapping("tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

}
