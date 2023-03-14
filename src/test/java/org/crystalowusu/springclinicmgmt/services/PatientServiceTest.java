package org.crystalowusu.springclinicmgmt.services;


import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest{
    
   private Patient patient;
   
   @Mock
   private PatientsRepo pRepo;
   
   
   @InjectMocks
   private PatientService patientService;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setEmail("crystal@mail.com");
        patient.setFullName("First doctor");
        patient.setBirthDate("2202");
        patient.setGender("M");
        patient.setPhone("792");
        patient.setAddress("231 street ave");
    }

    @Test
    public void givenPatientObjectWhenSavePatientReturnSavedPatient(){
        BDDMockito.given(pRepo.save(patient)).willReturn(patient);
        Patient savedPatient = patientService.savePatient(patient);
        assertThat(savedPatient).isEqualTo(patient);

    }
}
