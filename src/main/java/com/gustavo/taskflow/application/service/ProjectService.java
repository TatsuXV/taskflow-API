package com.gustavo.taskflow.application.service;

import com.gustavo.taskflow.domain.model.Project;
import com.gustavo.taskflow.domain.repository.ProjectRepository;
import com.gustavo.taskflow.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

   public List <Project> findAll(){
       return projectRepository.findAll();
   }

    public Optional findbyId(long id){
        return projectRepository.findById(id);
    }

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public void delete(long id){
        projectRepository.deleteById(id);
    }
}
