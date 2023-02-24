package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="Doctor_Table")

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;

    private String name;
    private String username;
    private String password;
}