package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
@Entity
@Table(name="Admin_table")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", unique = true)
    private Long adminId;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 70)
    private String password;


   // private Patient patient;
    //private Doctor doctor;




}