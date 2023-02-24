package com.clinicmgmt.springclinicmgmt.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Info_Table")

public class Visit_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private String diagnosis;
    @ManyToOne
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;
    private LocalDateTime visit_date;
    private String billed;
    private String med_prescribed;
}