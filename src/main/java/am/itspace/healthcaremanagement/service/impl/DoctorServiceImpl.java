package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.Doctor;
import am.itspace.healthcaremanagement.repository.DoctorRepository;
import am.itspace.healthcaremanagement.service.DoctorService;
import am.itspace.healthcaremanagement.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Value("${healthcare_management.doctor.upload.image.path}")
    private String doctorImageUploadPath;

    @Override
    public List<Doctor> allDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void addDoctor(Doctor doctor, MultipartFile multipartFile) {
        try {
            String images = ImageUtil.uploadImage(multipartFile, doctorImageUploadPath);
            doctor.setProfilePic(images);
        } catch (IOException e) {
            e.printStackTrace();
        }
        doctorRepository.save(doctor);
    }
    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
