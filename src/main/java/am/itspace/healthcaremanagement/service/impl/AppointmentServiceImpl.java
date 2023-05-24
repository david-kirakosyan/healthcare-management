package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.entity.type.UserType;
import am.itspace.healthcaremanagement.repository.AppointmentRepository;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> allAppointments(CurrentUser currentUser) {
        List<Appointment> appointments;
        if (currentUser.getUser().getUserType() == UserType.USER) {
            appointments = appointmentRepository.findAllByPatient_id(currentUser.getUser().getId());
        } else if (currentUser.getUser().getUserType() == UserType.ADMIN) {
            appointments = appointmentRepository.findAllByDoctor_id(currentUser.getUser().getId());
        } else {
            appointments = appointmentRepository.findAll();
        }
        return appointments;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
