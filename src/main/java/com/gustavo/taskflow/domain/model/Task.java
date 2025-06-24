package com.gustavo.taskflow.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_task")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private TaskStatus status;

    private LocalDate createdAt = LocalDate.now();

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
