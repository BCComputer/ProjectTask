package com.projectIdea.ProjectTask.service;

import com.projectIdea.ProjectTask.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {

        public List<Task> getAllTasks();
        public Task getTaskById(Long id);
        public Task createTask(Long projectId, Task task);
        public Task updateTask(Long id, Task taskDetails);
        public void deleteTask(Long id);

}
