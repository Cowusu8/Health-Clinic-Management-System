package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Patient_Table")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;
    private String username;
    private String password;
    private LocalDateTime birth_date;
    private LocalDateTime appointment;
    private String phone_no;
}