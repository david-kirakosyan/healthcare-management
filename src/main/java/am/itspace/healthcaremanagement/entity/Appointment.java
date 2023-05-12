package am.itspace.healthcaremanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datetime;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
