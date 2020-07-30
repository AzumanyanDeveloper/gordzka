package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.CurrentUser;
import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.service.LocationService;
import am.gordzka.gordzka.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    private final LocationService locationService;

    @GetMapping("/allTasksPage")
    public String findAllTasks(@AuthenticationPrincipal CurrentUser user,Model model) {
        List<Location> locations = locationService.allLocations();
        List<Task> allTasks = taskService.allTasks();
        model.addAttribute("alltasks", allTasks);
        model.addAttribute("locations",locations);
        model.addAttribute("currentUser",user);
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
