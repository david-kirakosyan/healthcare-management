package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.repository.PatientRepository;
import am.itspace.healthcaremanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id){
        patientRepository.deleteById(id);
    }
}
