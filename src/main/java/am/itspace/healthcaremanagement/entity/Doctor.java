package am.itspace.healthcaremanagement.entity;

import am.itspace.healthcaremanagement.entity.type.SpecialtyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private SpecialtyType specialty;
    private String phoneNumber;
    private String profilePic;
    @ManyToOne
    private User user;
}
