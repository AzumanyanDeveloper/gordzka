package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repozitory.UserRepozitory;
import am.gordzka.gordzka.service.LocationService;
import am.gordzka.gordzka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LocationService locationService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepozitory userRepozitory;

    @GetMapping("/candidates-listing")
    public String getCandList(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allusers", allUsers);
        return "candidates-listing";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute User user) {
        Optional<User> userbyEmail = userRepozitory.findByEmail(user.getEmail());
        if (userbyEmail.isPresent()) {
            return "redirect:/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/login-register";
    }

    @GetMapping("/register")
    public String userRegister(Model model){
        List<Location> locations = locationService.allLocations();
        model.addAttribute("locations",locations);
        model.addAttribute("msg", "Այս էլ․ հացեով օգտատեր գրանցված է կայքում");
        return "login-register";
    }
}
