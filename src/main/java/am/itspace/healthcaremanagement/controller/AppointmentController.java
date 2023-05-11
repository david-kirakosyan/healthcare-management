package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.repository.AppointmentRepository;
import am.itspace.healthcaremanagement.repository.DoctorRepository;
import am.itspace.healthcaremanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public String appointmentPage(ModelMap modelMap) {
        List<Appointment> appointments = appointmentRepository.findAll();
        modelMap.addAttribute("appointments", appointments);
        return "appointments";
    }

    @GetMapping("/appointments/add")
    public String addAppointmentPage(ModelMap modelMap) {
        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        modelMap.addAttribute("patients", patients);
        modelMap.addAttribute("doctors", doctors);
        return "addAppointment";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/delete")
    public String deleteAppointments(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }
}
