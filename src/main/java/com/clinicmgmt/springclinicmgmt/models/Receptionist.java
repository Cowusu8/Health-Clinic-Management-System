package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name="Receptionist_table")

public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReceptionistId", unique = true)
    private Long Id;
    @Column(name = "username")@NonNull
    private String username;
    @Column(name = "password", length = 70)
    private String password;

    @OneToOne
    @JoinColumn(name = "patients_patient_id")
    private Patients patients;


}