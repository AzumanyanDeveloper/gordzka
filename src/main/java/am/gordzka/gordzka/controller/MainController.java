package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.*;
import am.gordzka.gordzka.repository.UserRepository;
import am.gordzka.gordzka.service.CategoryService;
import am.gordzka.gordzka.service.LocationService;
import am.gordzka.gordzka.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {
    private final CategoryService categoryService;

    private final TaskService taskService;

    private final LocationService locationService;

    private final UserRepository userRepository;

    @GetMapping("/")
    public String main() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            user = userRepository.findByEmail(authentication.getName()).orElse(null);
        } else if (authentication instanceof CurrentUser) {
            user = ((CurrentUser) authentication).getUser();
        }
        List<Category> topCategory = categoryService.getTopCategory();
        List<Task> topTasks = taskService.allTasksByType();
        List<Location> locations = locationService.allLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("topTasks", topTasks);
        model.addAttribute("categories", topCategory);
        model.addAttribute("currentUser", user);
        return "index";
    }


    @GetMapping("/successLogin")
    public String successLogin(@AuthenticationPrincipal CurrentUser user, Model model) {
        if (user == null) {
            return "redirect:/login-register?msg=User does not exist";
        } else {
            List<Category> topCategory = categoryService.getTopCategory();
            List<Task> topTasks = taskService.allTasksByType();
            model.addAttribute("topTasks", topTasks);
            model.addAttribute("categories", topCategory);
            model.addAttribute("currentUser", user);
            return "index";
        }

    }

    @GetMapping("/login-register")
    public String loginRegisterPageGet(Model model) {
        List<Location> locations = locationService.allLocations();
        model.addAttribute("locations", locations);
        return "login-register";
    }

}