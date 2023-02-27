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
    @Column(name = "patientId")
    private Long patientId;

    // private Patient patient;
    @Column(name = "visitDate_Date")
    private LocalDateTime visitDate;
    @Column(name = "quote_string")
    private String billed;
    @Column(name = "diagnosis_string")
    private String diagnosis;
    @Column(name = "prescription_string")
    private String prescription;
}