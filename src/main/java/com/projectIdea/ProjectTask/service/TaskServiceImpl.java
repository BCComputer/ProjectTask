package com.projectIdea.ProjectTask.service;

import com.projectIdea.ProjectTask.entities.Project;
import com.projectIdea.ProjectTask.entities.Task;
import com.projectIdea.ProjectTask.exceptions.TaskNotFoundException;
import com.projectIdea.ProjectTask.repository.ProjectRepository;
import com.projectIdea.ProjectTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Task> getAllTasks() {
        List<Task> allTasks = taskRepository.findAll();
        if(allTasks.isEmpty()){
            throw new TaskNotFoundException("Task not found");
        }else{
            return allTasks;
        }
    }

    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new TaskNotFoundException("Task not found");
        }else{
            return task.get();
        }
    }

    public Task createTask(Long projectId, Task task) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setProject(project);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new TaskNotFoundException("Task not found");
        }else{
            task.get().setName(taskDetails.getName());
            task.get().setStatus(taskDetails.getStatus());
            return taskRepository.save(task.get());
        }
    }

    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new TaskNotFoundException("Task not found");
        }else{
            taskRepository.delete(task.get());
        }

    }
}
