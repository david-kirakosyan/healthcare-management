package am.itspace.healthcaremanagement.repository;

import am.itspace.healthcaremanagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findAllByUser_id(int userId);
}
