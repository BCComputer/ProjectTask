package com.projectIdea.ProjectTask.service;

import com.projectIdea.ProjectTask.entities.Project;
import com.projectIdea.ProjectTask.exceptions.ProjectNotFoundException;
import com.projectIdea.ProjectTask.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        Optional<Project> byId = projectRepository.findById(id);
        if(byId.isEmpty()){
            throw new ProjectNotFoundException("Requested Project with " + id + " does not exit in our system");
        }else {
            return byId.get();
        }

    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isEmpty()){
            throw new ProjectNotFoundException("Requested Project with " + id + " does not exit in our system");
        }else {
            project.get().setName(projectDetails.getName());
            project.get().setDescription(projectDetails.getDescription());
            return projectRepository.save(project.get());
        }
    }

    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById((id));
        if(project.isEmpty()){
            throw new ProjectNotFoundException("Requested Project with " + id + " does not exit in our system");
        }else {
            projectRepository.delete(project.get());
        }
    }
}
