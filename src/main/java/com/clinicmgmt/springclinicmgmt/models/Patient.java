package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Patients_Table")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId", unique = true)
    private Long patientId;
    @Column(name = "firstname_string")
    private String firstname;
    @Column(name = "lastname_string")
    private String lastname;
    @Column(name = "username_string")
    private String username;
    @Column(name = "password_string")
    private String password;
    @Column(name = "date_date")
    private LocalDateTime birth_date;
    @Column(name = "appointment_date")
    private LocalDateTime appointment;
    @Column(name = "phone_string")
    private String phone_no;

}