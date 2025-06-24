package com.gustavo.taskflow.application.service;

import com.gustavo.taskflow.domain.model.Task;
import com.gustavo.taskflow.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional <Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
