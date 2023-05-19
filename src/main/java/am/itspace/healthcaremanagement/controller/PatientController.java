package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientController {

    private final PatientService PATIENT_SERVICE;

    @GetMapping("/patients")
    public String patientPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null){
            modelMap.addAttribute("user",currentUser.getUser());
        }
        List<Patient> patients = PATIENT_SERVICE.allPatients();
        modelMap.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/patients/add")
    public String addPatientPage() {
        return "patients";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute Patient patient,
                             @AuthenticationPrincipal CurrentUser currentUser) {
        PATIENT_SERVICE.addPatient(patient, currentUser);
        return "redirect:/patients";
    }

    @GetMapping("/patients/delete")
    public String deletePatent(@RequestParam("id") int id) {
        PATIENT_SERVICE.deletePatient(id);
        return "redirect:/patients";
    }
}
