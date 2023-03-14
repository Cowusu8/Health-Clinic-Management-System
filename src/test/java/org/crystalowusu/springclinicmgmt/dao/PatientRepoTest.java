package org.crystalowusu.springclinicmgmt.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PatientRepoTest {

    @Autowired
    PatientsRepo patientsRepo;

    private Patient firstPatient;

    @BeforeEach
    void setUp() {
        firstPatient = new Patient();
        firstPatient.setEmail("crystal@mail.com");
        firstPatient.setFullName("First doctor");
        firstPatient.setBirthDate("2202");
        firstPatient.setGender("M");
        firstPatient.setPhone("792");
        firstPatient.setAddress("231 street ave");
        patientsRepo.save(firstPatient);
    }

    @Test
    public void givenIdWhenFindById() {
        System.out.println("Testing Id...");
        System.out.println("Before each test: " + patientsRepo.findAll().size());

        Long id = 1L;
        Patient foundPatient = patientsRepo.findById(id).get();
        assertThat(foundPatient.getId()).isEqualTo(id);
    }
    }


