package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.CurrentUser;
import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@RequiredArgsConstructor
public class MainController {

    @Value("${file.upload.dir}")
    private String uploadDir;


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
        model.addAttribute("currentUser", user);
        return "index";
    }


    @GetMapping("/successLogin")
    public String successLogin(@AuthenticationPrincipal CurrentUser user, Model model) {
        if (user == null) {
            return "redirect:/login-register?msg=User does not exist";
        } else {
            model.addAttribute("currentUser", user);
            return "index";
        }

    }

    @GetMapping("/login-register")
    public String loginRegisterPageGet() {
        return "login-register";
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {

        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }

}