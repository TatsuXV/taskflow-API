package com.gustavo.taskflow.application.service;

import com.gustavo.taskflow.domain.model.User;
import com.gustavo.taskflow.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List <User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findbyId(Long id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
