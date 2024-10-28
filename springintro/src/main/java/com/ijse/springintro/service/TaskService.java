
package com.ijse.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springintro.Entity.Task;

@Service
public interface TaskService {
    List<Task> getTasksList(); //reading
    Task createTask(Task task);  //creating

    


}