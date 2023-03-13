// Required package modules
package org.crystalowusu.springclinicmgmt.models;

// Importing required classes
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

//Lombok and Data JPA Annotations
@Getter
@Setter
@ToString
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Doctors_Table")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor { // Class

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @NonNull @Column (unique = true)
    private long id;
    @NonNull @Column(name = "fullName",length = 100)
    private String fullName;
    @NonNull @Column(name = "birthDate",length = 10)
    private String birthDate;
    @NonNull @Column(name="gender", length = 7)
    private String gender;
    @NonNull @Column(name = "phone", length = 12)
    private String phone;
    @NonNull @Column(name="address", length = 100)
    private String address;
    @NonNull @Column(name = "email", length = 100)
    private String email;

//    public Doctor(@NonNull String fullName, @NonNull String birthDate, @NonNull String gender, @NonNull String phone, @NonNull String address, @NonNull String email) {
//        this.fullName = fullName;
//        this.birthDate = birthDate;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.email = email;
//        //this.password = setPassword(password);
////        //this.patients = patients;
//    }

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH,CascadeType.REMOVE})
    Set<Patient> patients = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return id == doctor.id && fullName.equals(doctor.fullName) && birthDate.equals(doctor.birthDate) && gender.equals(doctor.gender) && phone.equals(doctor.phone) && address.equals(doctor.address) && email.equals(doctor.email) && Objects.equals(patients, doctor.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, birthDate, gender, phone, address, email, patients);
    }



}