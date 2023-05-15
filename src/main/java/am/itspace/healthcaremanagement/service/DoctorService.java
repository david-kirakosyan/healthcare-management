package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Doctor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {
    List<Doctor> allDoctor();

    void addDoctor(Doctor doctor, MultipartFile multipartFile) throws IOException;

    void deleteDoctor(int id);
}
