package com.projectIdea.ProjectTask.repository;

import com.projectIdea.ProjectTask.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}

