package com.projectIdea.ProjectTask.repository;

import com.projectIdea.ProjectTask.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}

