package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.repository.AppointmentRepository;
import am.itspace.healthcaremanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> allAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> patientById(int id) {
        return appointmentRepository.findAllByPatient_id(id);
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
