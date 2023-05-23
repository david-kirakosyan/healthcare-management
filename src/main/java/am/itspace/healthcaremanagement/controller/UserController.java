package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.entity.User;
import am.itspace.healthcaremanagement.service.DoctorService;
import am.itspace.healthcaremanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService USER_SERVICE;

    @GetMapping("/register")
    public String addDoctorPage() {
        return "register";
    }

    @PostMapping("/register")
    public String addDoctor(@ModelAttribute User user) {
        USER_SERVICE.userSave(user);
        return "redirect:/";
    }
}
