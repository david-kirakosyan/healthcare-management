package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Appointment;
import am.itspace.healthcaremanagement.security.CurrentUser;

import java.util.List;

public interface AppointmentService {
    List<Appointment> allAppointments(CurrentUser currentUser);

    void addAppointment(Appointment appointment);

    void deleteAppointment(int id);
}
