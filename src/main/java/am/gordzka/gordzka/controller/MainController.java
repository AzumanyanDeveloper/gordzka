package am.gordzka.gordzka.controller;
import am.gordzka.gordzka.model.Category;
import am.gordzka.gordzka.service.CategoryService;
import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CategoryService categoryService;
    
    private final TaskService taskService;

    @GetMapping("/")
    public String home(Model model) {
        List<Category> topCategory = categoryService.getTopCategory();
        List<Task> topTasks = taskService.allTasksByType();
        model.addAttribute("topTasks",topTasks);
        model.addAttribute("categories",topCategory);
        return "index";
    }

}