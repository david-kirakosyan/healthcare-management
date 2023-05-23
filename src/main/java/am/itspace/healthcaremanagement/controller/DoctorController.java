package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService DOCTOR_SERVICE;

    @GetMapping
    public String doctorPage(ModelMap modelMap) {
        List<Doctor> doctors = DOCTOR_SERVICE.allDoctors();
        modelMap.addAttribute("doctors", doctors);
        return "doctors";
    }

    @GetMapping("/add")
    public String addDoctorPage() {
        return "doctors";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor,
                            @RequestParam("image") MultipartFile multipartFile,
                            @AuthenticationPrincipal CurrentUser currentUser) {
        DOCTOR_SERVICE.addDoctor(doctor, multipartFile,currentUser);
        return "redirect:/doctors";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
        DOCTOR_SERVICE.deleteDoctor(id);
        return "redirect:/doctors";
    }
}
