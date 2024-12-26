package com.app.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoapp.repository.TaskRepository;

import com.app.todoapp.models.*;

@Service
public class TaskService {
    public final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public void createTask(String title) {
        // TODO Auto-generated method stub
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
        
    }
    public void deleteTasks(Long id) {
        // TODO Auto-generated method stub
        taskRepository.deleteById(id);
    }
    public void toggleTasks(Long id) {
        // TODO Auto-generated method stub
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
