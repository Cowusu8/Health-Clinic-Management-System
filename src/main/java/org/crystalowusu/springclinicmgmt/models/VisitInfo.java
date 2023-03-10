package org.crystalowusu.springclinicmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="VisitInfo")

public class VisitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visitID")
    private Long Id;@NonNull
    @Column(name = "visitDate")
    private String visitDate;@NonNull
    @Column(name = "billing")
    private Boolean billed;@NonNull
    @Column(name = "diagnosis")
    private String diagnosis;@NonNull
    @Column(name = "prescription")
    private String prescription;@NonNull

    @OneToOne(mappedBy = "visitInfo")
    Patient patient;



}
