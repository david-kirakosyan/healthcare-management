package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> allAppointments();

    void addAppointment(Appointment appointment);

    void deleteAppointment(int id);
}
