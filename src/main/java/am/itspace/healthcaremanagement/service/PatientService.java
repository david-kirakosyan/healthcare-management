package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.security.CurrentUser;

import java.util.List;

public interface PatientService {
    List<Patient> allPatients();

    void addPatient(Patient patient, CurrentUser currentUser);

     List<Patient> userById(int id);
    void deletePatient(int id);
}
