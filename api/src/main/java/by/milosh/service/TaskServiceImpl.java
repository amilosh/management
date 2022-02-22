package by.milosh.service;

import by.milosh.dto.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task createWithName(String name) {
        Task task = new Task();
        task.setName(name);
        return task;
    }
}
