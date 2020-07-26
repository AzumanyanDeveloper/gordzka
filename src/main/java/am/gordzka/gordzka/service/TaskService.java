package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.model.Type;
import am.gordzka.gordzka.repozitory.TaskRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> allTasksByType() {
        return taskRepository.findAllByType(Type.TOP);
    }
  





}