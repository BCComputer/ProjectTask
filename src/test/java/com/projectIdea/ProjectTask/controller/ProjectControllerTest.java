package com.projectIdea.ProjectTask.controller;

import com.projectIdea.ProjectTask.entities.Project;
import com.projectIdea.ProjectTask.service.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {
    @Mock
    private ProjectService projectService;
    @InjectMocks
    private ProjectController projectController;


    @Test
    void test_getAllProjects_success() {
        List<Project> projectList = new ArrayList<>();
        Project myProject = new Project();
        myProject.setName("Project1");
        myProject.setDescription("This is first project");
        projectList.add(myProject);

        Mockito.when(projectService.getAllProjects()).thenReturn(projectList);
        ResponseEntity<List<Project>> allProjects = projectController.getAllProjects();
        Assertions.assertEquals(projectList.get(0).getDescription(), allProjects.getBody().get(0).getDescription());
        Assertions.assertNotNull(allProjects);
    }

    @Test
    void test_getProjectById_success() {

    }

    @Test
    void test_createProject_success() {
    }

    @Test
    void test_updateProject_success() {
    }

    @Test
    void test_deleteProject_success() {
    }
}