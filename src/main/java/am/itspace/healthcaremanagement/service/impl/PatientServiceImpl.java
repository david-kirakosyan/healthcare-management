package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.Patient;
import am.itspace.healthcaremanagement.entity.type.UserType;
import am.itspace.healthcaremanagement.repository.PatientRepository;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public List<Patient> allPatients(CurrentUser currentUser) {
        List<Patient> patients;
        if (currentUser.getUser().getUserType() == UserType.ADMIN){
           patients = patientRepository.findAll();
        }else {
            patients = patientRepository.findAllByUser_id(currentUser.getUser().getId());
        }
        return patients;
    }

    @Override
    public void addPatient(Patient patient, CurrentUser currentUser) {
        patient.setUser(currentUser.getUser());
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id){
        patientRepository.deleteById(id);
    }
}
