package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.security.CurrentUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DoctorService {
    List<Doctor> allDoctors();

    void addDoctor(Doctor doctor, MultipartFile multipartFile, CurrentUser currentUser);

    void deleteDoctor(int id);
}
