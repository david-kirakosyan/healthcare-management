package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService = new DoctorServiceImpl();

    @GetMapping("/doctors")
    public String doctorPage(ModelMap modelMap) {
        List<Doctor> doctors = doctorService.allDoctor();
        modelMap.addAttribute("doctors",doctors);
        return "doctors";
    }

    @GetMapping("/doctors/add")
    public String addDoctorPage() {
        return "doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctor doctor, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        doctorService.addDoctor(doctor,multipartFile);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}
