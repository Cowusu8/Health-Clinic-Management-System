package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


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
    @Column(name="gender", length = 7, nullable = false)
    private String gender;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "birthdate", nullable = false, length = 10)
    private String birthDate;
    @Column(name="address",  nullable = false, length = 100)
    private String address;
    @Column(name = "phone", unique = true, nullable = false,length = 12)
    private String phone;

    @OneToMany
    @JoinColumn(name = "visitinfo_visit_id")
    private Set<VisitInfo> visits;

//    @OneToMany(mappedBy = "patients")
//    Set<VisitInfo> visitInfo;



}