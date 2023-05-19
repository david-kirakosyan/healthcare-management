package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.AppointmentService;
import am.itspace.healthcaremanagement.service.DoctorService;
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
public class AppointmentController {

    private final AppointmentService APPOINTMENT_SERVICE;
    private final DoctorService DOCTOR_SERVICE;
    private final PatientService PATIENT_SERVICE;


    @GetMapping("/appointments")
    public String appointmentPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            modelMap.addAttribute("user", currentUser.getUser());
        }
        List<Appointment> appointments = APPOINTMENT_SERVICE.allAppointments();
        modelMap.addAttribute("appointments", appointments);
        return "appointments";
    }

    @GetMapping("/appointments/add")
    public String addAppointmentPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            modelMap.addAttribute("user", currentUser.getUser());
        }
        List<Patient> patients = PATIENT_SERVICE.allPatients();
        List<Doctor> doctors = DOCTOR_SERVICE.allDoctors();
        modelMap.addAttribute("patients", patients);
        modelMap.addAttribute("doctors", doctors);
        return "addAppointment";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        APPOINTMENT_SERVICE.addAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/delete")
    public String deleteAppointments(@RequestParam("id") int id) {
        APPOINTMENT_SERVICE.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
