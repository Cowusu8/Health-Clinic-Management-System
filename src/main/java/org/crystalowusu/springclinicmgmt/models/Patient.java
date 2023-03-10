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
    @Column(name = "Id", unique = true)
    private Long Id;@NonNull
    @Column(name = "fullName", length = 100)
    private String fullName;@NonNull
    @Column(name="gender", length = 7)
    private String gender;@NonNull
    @Column(name = "email",length = 100, unique = true)
    private String email;@NonNull
    @Column(name = "birthdate", length = 10)
    private String birthDate;@NonNull
    @Column(name="address", length = 100)
    private String address;@NonNull
    @Column(name = "phone", unique = true, length = 12)
    private String phone;@NonNull
    @Column(name = "appointmentDate", length = 10)
    private String appointmentDate;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "doctor_patients",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    Set<Doctor> doctors = new LinkedHashSet<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "patients_table_visit_info",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "visit_info_visitid"))
    @NonNull
    private VisitInfo visitInfo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Id.equals(patient.Id) && fullName.equals(patient.fullName) && gender.equals(patient.gender) && email.equals(patient.email) && birthDate.equals(patient.birthDate) && address.equals(patient.address) && phone.equals(patient.phone) && doctors.equals(patient.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, gender, email, birthDate, address, phone, doctors,appointmentDate);
    }
}