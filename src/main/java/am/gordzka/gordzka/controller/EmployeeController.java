package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Category;
import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.service.CategoryService;
import am.gordzka.gordzka.service.LocationService;
import am.gordzka.gordzka.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@ControllerAdvice
@RequiredArgsConstructor
public class EmployeeController {

    private final CategoryService categoryService;
    private final LocationService locationService;
    private final TaskService taskService;


    @ModelAttribute
    public List<Task> topTasks( ModelMap model) {
        List<Task> topTasks = taskService.allTasksByType();
        model.addAttribute("topTasks",topTasks);

        return topTasks;
    }

    @ModelAttribute
    public List<Category> categories(ModelMap model) {
        List<Category> topCategory = categoryService.getTopCategory();
        model.addAttribute("categories", topCategory);
        return topCategory;
    }


    @ModelAttribute
    public List<Location> locations(ModelMap model) {
        List<Location> locations = locationService.allLocations();
        model.addAttribute("locations", locations);

        return locations;
    }
}
