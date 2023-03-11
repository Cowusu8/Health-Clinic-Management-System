package org.crystalowusu.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;


//@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Doctors_Table")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @NonNull @Column(name = "name",length = 100)
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
    @NonNull @Setter(AccessLevel.NONE)
    private String password;


/*
    public String setPassword(String password)  {
        return   this.password = new BCryptPasswordEncoder(4).encode(password);
    }
*/


    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH,CascadeType.REMOVE})
    Set<Patient> patients = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Id.equals(doctor.Id) && fullName.equals(doctor.fullName) && email.equals(doctor.email) && birthDate.equals(doctor.birthDate) && gender.equals(doctor.gender) && address.equals(doctor.address) && phone.equals(doctor.phone) && patients.equals(doctor.patients)&& password.equals(doctor.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, email, birthDate, gender, address, phone, patients,password);
    }

    /*public List<String> controllerGetPatients() {
        List<String> patient= new ArrayList<>();
        for (Patient p:patients){
            patient.add(p.getFullName());


        }
        return patient;
    }*/

}