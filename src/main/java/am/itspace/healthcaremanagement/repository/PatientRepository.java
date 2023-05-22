package am.itspace.healthcaremanagement.repository;

import am.itspace.healthcaremanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    List<Patient> findAllByUser_id(int userId);
}
