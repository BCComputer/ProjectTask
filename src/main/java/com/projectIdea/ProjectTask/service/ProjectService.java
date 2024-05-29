package com.projectIdea.ProjectTask.service;

import com.projectIdea.ProjectTask.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjectService {
    public List<Project> getAllProjects();
    public Project getProjectById(Long id);
    public Project createProject(Project project);
    public Project updateProject(Long id, Project projectDetails);
    public void deleteProject(Long id);

}
