package by.milosh.controller;

import by.milosh.dto.Task;
import by.milosh.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    public Task createTask(@PathVariable(name = "name") String name) {
        return taskService.createWithName(name);
    }
}
