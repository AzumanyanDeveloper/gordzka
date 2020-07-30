package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repository.UserRepository;
import am.gordzka.gordzka.service.LocationService;
import am.gordzka.gordzka.service.SecurityService;
import am.gordzka.gordzka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LocationService locationService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SecurityService securityService;


    @PostMapping("/register")
    public String userRegister(HttpServletRequest httpRequest, @ModelAttribute User user) {
        Optional<User> userbyEmail = userRepository.findByEmail(user.getEmail());
        if (userbyEmail.isPresent()) {
            return "redirect:/register";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            securityService.autoLogin(httpRequest, user.getEmail(), user.getPassword());
            return "redirect:/";
        }
    }


    @GetMapping("/register")
    public String userRegister(Model model) {
        List<Location> locations = locationService.allLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("msg", "Այս էլ․ հացեով օգտատեր գրանցված է կայքում");
        return "login-register";
    }
}
