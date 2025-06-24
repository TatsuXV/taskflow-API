package com.gustavo.taskflow.controller;

import com.gustavo.taskflow.application.service.ProjectService;
import com.gustavo.taskflow.domain.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll(){
        return projectService.findAll();
    }

    @GetMapping
    public ResponseEntity<Project> getById(@PathVariable Long id){
        return projectService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project create(@RequestBody Project project){
        return projectService.save(project);
    }

    @PutMapping
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project){
        return projectService.findById(id)
                .map(existing ->{
                    project.setId(id);
                    return ResponseEntity.ok(projectService.save(project));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return projectService.findById(id)
                .map(existing -> {
                    projectService.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
