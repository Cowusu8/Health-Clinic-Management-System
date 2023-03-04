package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Patients_Table")

public class Patients {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private Long Id;
    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "birthdate", nullable = false)
    private String birthDate;
    @Column(name = "appointment", nullable = false)
    private String appointment;
    @Column(name = "phone", unique = true, nullable = false)
    private Long phoneNo;

    @ManyToOne
    @JoinColumn(name = "doctors_doctor_id")
    private Doctors doctors;


}