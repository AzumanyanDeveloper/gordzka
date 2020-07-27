package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    @GetMapping("/candidates-listing")
    public String getCandList(Model model){
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allusers",allUsers);
        return "candidates-listing";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/";
    }
}
