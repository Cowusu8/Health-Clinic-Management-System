package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
@Entity
@Table(name="Visit_Info_Table")

public class Visit_Info {

    @Id @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;


    @ManyToOne
    @JoinColumn(name ="Patient")
    private Patient patient;

    private LocalDateTime visit_date;
    private String billed;
    private String diagnosis;
    private String med_prescribed;
    private String patientDiagnosis;
}