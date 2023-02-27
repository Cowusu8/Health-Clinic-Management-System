package com.clinicmgmt.springclinicmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="VisitInfo_Table")

public class VisitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

   // private Patient patient;

    private LocalDateTime visit_date;
    private String billed;
    private String diagnosis;
    private String med_prescribed;
    private String patientDiagnosis;
}