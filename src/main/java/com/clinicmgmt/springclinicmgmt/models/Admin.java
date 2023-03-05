package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name="Admin_table")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true)
    private Long Id;
    @Column(name = "username")@NonNull
    private String username;
    @Column(name = "password", length = 70)
    private String password;

    @OneToOne
    @JoinColumn(name = "doctors_doctor_id")
    private Doctors doctors;
    @OneToOne
    @JoinColumn(name = "receptionist_receptionist_id")
    private Receptionist receptionist;

}