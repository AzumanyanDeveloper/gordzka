package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("/allTasksPage")
    public String findAllTasks(Model model) {
        List<Task> allTasks = taskService.allTasks();
        model.addAttribute("alltasks", allTasks);
        return "listing";
    }

    @GetMapping("/searchTasks")
    public String serachTasks(@RequestParam(defaultValue="") String keyword, @RequestParam("locationId") int id, Model model){
        if (!keyword.equals("") && id == 0){
            List<Task> tasks = taskService.serachTasksByKeyword(keyword);
            model.addAttribute("tasks",tasks);
            return "index";
        }else if (!keyword.equals("")) {
            List<Task> tasks = taskService.serachTasksByKeywordAndLocationId(keyword, id);
            model.addAttribute("tasks",tasks);
            return "index";
        }else{
            return "redirect:/";
        }

    }

}
