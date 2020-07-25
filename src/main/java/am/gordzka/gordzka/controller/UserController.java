package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/candidates-listing")
    public String getCandList(Model model){
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allusers",allUsers);
        return "candidates-listing";
    }
}
