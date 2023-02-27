package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="Doctors_Table")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId", unique = true)
    private Long doctorId;
    @Column(name = "name_string")
    private String name;
    @Column(name = "username_string")
    private String username;
    @Column(name = "password_string")
    private String password;

//    private Patient patient;

}