package org.crystalowusu.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Patients_Table")

public class Patient {

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

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "doctor_patients",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    Set<Doctor> doctors = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Id.equals(patient.Id) && fullName.equals(patient.fullName) && gender.equals(patient.gender) && email.equals(patient.email) && birthDate.equals(patient.birthDate) && address.equals(patient.address) && phone.equals(patient.phone) && doctors.equals(patient.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, gender, email, birthDate, address, phone, doctors);
    }
}