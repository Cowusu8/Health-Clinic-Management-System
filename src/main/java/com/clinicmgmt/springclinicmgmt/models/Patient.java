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
    private Integer patientId;

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private LocalDateTime birth_date;
    private LocalDateTime appointment;
    private String phone_no;
}