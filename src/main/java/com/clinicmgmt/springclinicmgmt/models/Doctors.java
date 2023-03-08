package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;


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
    @Column(name = "Id", unique = true,nullable = false)
    private Long Id;
    @Column(name = "name", nullable = false, length = 100)
    private String fullName;
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "birthDate", nullable = false, length = 10)
    private String birthDate;
    @Column(name="gender", nullable = false, length = 7)
    private String gender;
    @Column(name="address",  nullable = false, length = 100)
    private String address;
    @Column(name = "phone", unique = true, nullable = false,length = 12)
    private String phone;

    @OneToMany
    @JoinColumn(name = "visit_info_visit_id")
//    private VisitInfo visitInfo;
    private Set<VisitInfo> visits;


}