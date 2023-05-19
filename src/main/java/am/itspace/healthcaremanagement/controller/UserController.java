package am.itspace.healthcaremanagement.controller;


import am.itspace.healthcaremanagement.entity.User;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService USER_SERVICE;

    @GetMapping("/register")
    public String registerPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null){
            modelMap.addAttribute("user", currentUser.getUser());
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        USER_SERVICE.userRegister(user);
        return "redirect:/";
    }
}
