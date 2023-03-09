package org.crystalowusu.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;


//@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name="Doctors_Table")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true,nullable = false)
    private Long Id;
    @Column(name = "name", nullable = false, length = 100)
    private String fullName;
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Setter(AccessLevel.NONE)
    private String password;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "birthDate", nullable = false, length = 10)
    private String birthDate;
    @Column(name="gender", nullable = false, length = 7)
    private String gender;
    @Column(name="address",  nullable = false, length = 100)
    private String address;
    @Column(name = "phone", unique = true, nullable = false,length = 12)
    private String phone;


    public String setPassword(String password)  {
        return   this.password = new BCryptPasswordEncoder(4).encode(password);
    }

    public Doctor(@NonNull String fullName, @NonNull String username, @NonNull String password,@NonNull String email, @NonNull String birthDate, @NonNull String gender, @NonNull String address, @NonNull String phone) {

        this.fullName = fullName;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        this.password = setPassword(password);
    }

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH,CascadeType.REMOVE})
    Set<Patient> patients = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Id.equals(doctor.Id) && fullName.equals(doctor.fullName) && username.equals(doctor.username) && email.equals(doctor.email) && password.equals(doctor.password) && birthDate.equals(doctor.birthDate) && gender.equals(doctor.gender) && address.equals(doctor.address) && phone.equals(doctor.phone) && patients.equals(doctor.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, username, email, password, birthDate, gender, address, phone, patients);
    }

    public List<String> controllerGetPatients() {
        List<String> patient= new ArrayList<>();
        for (Patient p:patients){
            patient.add(p.getFullName());


        }
        return patient;
    }

}