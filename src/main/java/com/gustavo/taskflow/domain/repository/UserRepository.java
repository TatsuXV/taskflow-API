package com.gustavo.taskflow.domain.repository;

import com.gustavo.taskflow.domain.model.Task;
import com.gustavo.taskflow.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
}
