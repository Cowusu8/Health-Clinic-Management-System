// Required package modules
package org.crystalowusu.springclinicmgmt.models;

// Importing required classes
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Objects;

//Lombok and Data JPA Annotations
@AllArgsConstructor
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="VisitInfo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VisitInfo { // Class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
    @NonNull
    private String fullName;
    @NonNull
    @Column(name = "birthdate", length = 10)
    private String birthDate;
    @NonNull
    @Column(name = "visitDate")
    private String visitDate;
    @NonNull
    @Column(name = "diagnosis")
    private String diagnosis;
    @NonNull
    @Column(name = "prescription")
    private String prescription;
    @NonNull

    @OneToOne(mappedBy = "visitInfo")
    Patient patient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitInfo visitInfo)) return false;
        return Objects.equals(Id, visitInfo.Id) && fullName.equals(visitInfo.fullName) && birthDate.equals(visitInfo.birthDate) && visitDate.equals(visitInfo.visitDate) && diagnosis.equals(visitInfo.diagnosis) && prescription.equals(visitInfo.prescription) && patient.equals(visitInfo.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName, birthDate, visitDate, diagnosis, prescription, patient);
    }
}
