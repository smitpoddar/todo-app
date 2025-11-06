package com.app.todoapp.controller;

import com.app.todoapp.entity.Task;
import com.app.todoapp.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {


    private final TaskServices taskServices;


    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = taskServices.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
        taskServices.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskServices.toggleTask(id);
        return "redirect:/";
    }
   



}
