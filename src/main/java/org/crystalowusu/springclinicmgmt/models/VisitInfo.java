package org.crystalowusu.springclinicmgmt.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;


@AllArgsConstructor
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="VisitInfo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VisitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
    @NonNull
    @Column(name = "visitDate")
    private String visitDate;
    @NonNull
    @Column(name = "billing")
    private Boolean billed;
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
        return Objects.equals(Id, visitInfo.Id) && visitDate.equals(visitInfo.visitDate) && billed.equals(visitInfo.billed) && diagnosis.equals(visitInfo.diagnosis) && prescription.equals(visitInfo.prescription) && patient.equals(visitInfo.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, visitDate, billed, diagnosis, prescription, patient);
    }


}
