package org.crystalowusu.springclinicmgmt.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;


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
    @Column(name = "Id", unique = true)
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
    @Column(name = "gender", nullable = false, length = 7)
    private String gender;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "phone", unique = true, nullable = false, length = 12)
    private String phone;
}