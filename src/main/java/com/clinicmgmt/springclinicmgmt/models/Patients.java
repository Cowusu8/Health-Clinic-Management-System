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
    @Column(name = "Id", unique = true)
    private Long patientId;
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;
    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "date", nullable = false)
    private String birth_date;
    @Column(name = "appointment", nullable = false)
    private String appointment;
    @Column(name = "phone", unique = true, nullable = false)
    private Long phone_no;

    @ManyToOne
    @JoinColumn(name = "doctors_doctor_id")
    private Doctors doctors;


}