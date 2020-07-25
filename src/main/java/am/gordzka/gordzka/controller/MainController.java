package am.gordzka.gordzka.controller;
import am.gordzka.gordzka.model.Category;
import am.gordzka.gordzka.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> topCategory = categoryService.getTopCategory();
        model.addAttribute("categories",topCategory);
        return "index";
    }

}
