package am.itspace.healthcaremanagement.repository;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> findAllByDoctor_id(int doctorId);
    List<Appointment> findAllByPatient_id(int patientId);
}
