package com.clinicmgmt.springclinicmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="VisitInfo_Table")

public class VisitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visitID")
    private Long Id;
    @Column(name = "visitDate")
    private String visitDate;
    @Column(name = "billing")
    private Boolean billed;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "prescription")
    private String prescription;

    @ManyToOne
    @JoinColumn(name = "patients_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "doctors_id")
    private Doctor doctor;

}
