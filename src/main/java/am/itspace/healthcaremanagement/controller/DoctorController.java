package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.repository.DoctorRepository;
import am.itspace.healthcaremanagement.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private DoctorRepository doctorRepository;


    @Value("${healthcare_management.doctor.upload.image.path}")
    private String doctorImageUploadPath;


    @GetMapping("/doctors")
    public String doctorPage(ModelMap modelMap) {
        List<Doctor> doctors = doctorRepository.findAll();
        modelMap.addAttribute("doctors", doctors);
        return "doctors";
    }

    @GetMapping("/doctors/add")
    public String addDoctorPage() {
        return "doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctor doctor, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String images = ImageUtil.uploadImage(multipartFile, doctorImageUploadPath);
        doctor.setProfilePic(images);
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

//    private String images(@RequestParam("image") MultipartFile multipartFile) throws IOException {
//        if (multipartFile != null && !multipartFile.isEmpty()) {
//            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
//            File file = new File(doctorImageUploadPath + fileName);
//            multipartFile.transferTo(file);
//            return fileName;
//        }
//        return null;
//    }

    @GetMapping("/doctors/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }
}
