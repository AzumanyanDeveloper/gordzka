package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.model.Type;
import am.gordzka.gordzka.repository.TaskRepository;

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

    public List<Task> allTasks() {
        return taskRepository.findAll();
    }


    public List<Task> serachTasksByKeywordAndLocationId(String name,int id){
        return taskRepository.findByNameLikeAndLocationId("%"+name+"%", id);
    }

    public List<Task> serachTasksByKeyword(String name){
        return taskRepository.findByNameLike("%"+name+"%");
    }





}