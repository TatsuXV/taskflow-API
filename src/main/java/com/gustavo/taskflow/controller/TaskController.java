package com.gustavo.taskflow.controller;

import com.gustavo.taskflow.application.service.TaskService;
import com.gustavo.taskflow.domain.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id){
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> uptade(@PathVariable Long id , @RequestBody Task task){
        return taskService.findById(id)
                .map(existing ->{
                    task.setId(id);
                    return ResponseEntity.ok(taskService.save(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return taskService.findById(id)
                .map(existing -> {
                    taskService.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
