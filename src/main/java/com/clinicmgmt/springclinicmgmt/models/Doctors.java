package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name="Doctors_Table")

public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId", unique = true,nullable = false)
    private Long Id;
    @Column(name = "name_string", nullable = false, length = 100)
    private String fullName;
    @Column(name = "username_string", nullable = false, length = 100)
    private String username;
    @Column(name = "password_string", nullable = false, length = 100)
    private String password;
    @Column(name="gender", nullable = false, length = 7)
    private String gender;



}