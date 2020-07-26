package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("/allTasksPage")
    public String findAllTasks(Model model) {
        List<Task> allTasks = taskService.allTasks();
        model.addAttribute("alltasks", allTasks);
        return "all-tasks-page";
    }

}
