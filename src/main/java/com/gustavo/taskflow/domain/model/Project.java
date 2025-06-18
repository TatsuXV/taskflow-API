package com.gustavo.taskflow.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_project")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    private String description;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User blind;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Task> tasks = new ArrayList<>();
}
