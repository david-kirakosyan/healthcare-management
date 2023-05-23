package am.itspace.healthcaremanagement.repository;

import am.itspace.healthcaremanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
