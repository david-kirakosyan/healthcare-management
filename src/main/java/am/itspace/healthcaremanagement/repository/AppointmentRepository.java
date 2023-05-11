package am.itspace.healthcaremanagement.repository;

import am.itspace.healthcaremanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
