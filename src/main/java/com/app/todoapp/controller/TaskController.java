package com.app.todoapp.controller;

//import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import com.app.todoapp.services.TaskService;
import com.app.todoapp.models.Task;

@Controller

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    @GetMapping   //endpoint 1
    public String getTasks(Model model){
        List<Task> tasks= taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping   //endpoint 2
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")   //endpoint 3
    public String deleteTasks(@PathVariable Long id){  //since we are accepting id to remove task
        taskService.deleteTasks(id);
        return "redirect:/";  //to refresh the page
    }
    @GetMapping("/{id}/toggle")   //endpoint 4
    public String toggleTasks(@PathVariable Long id){  
        taskService.toggleTasks(id);
        return "redirect:/";  //to refresh the page
    }
}
