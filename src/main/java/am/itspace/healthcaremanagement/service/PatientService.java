package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> allPatients();

    void addPatient(Patient patient);

    void deletePatient(int id);
}
