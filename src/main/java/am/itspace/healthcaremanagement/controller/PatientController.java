package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public String patientPage(ModelMap modelMap) {
        List<Patient> patients = patientRepository.findAll();
        modelMap.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/patients/add")
    public String addPatientPage() {
        return "patients";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/delete")
    public String deletePatent(@RequestParam("id") int id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}
