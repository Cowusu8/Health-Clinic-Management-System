package org.crystalowusu.springclinicmgmt.dao;


import jakarta.transaction.Transactional;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class DoctorsRepoTest {

    @Autowired
    private DoctorsRepo doctorsRepo;

    private Doctor firstDoctor;

    @BeforeEach
    void setup() {
        System.out.println("Before each test: " + doctorsRepo.findAll().size());
        firstDoctor = new Doctor();
        firstDoctor.setEmail("crystal@mail.com");
        firstDoctor.setFullName("First doctor");
        firstDoctor.setBirthDate("2202");
        firstDoctor.setGender("M");
        firstDoctor.setPhone("792");
        firstDoctor.setAddress("231 street ave");
        doctorsRepo.save(firstDoctor);
    }

    @Test
    public void givenIdWhenFindByID() {
        System.out.println("Testing id...");
        System.out.println("Before each test: " + doctorsRepo.findAll().size());

        Long id = 1L;
        Doctor foundDoctor = doctorsRepo.findById(id).get();
        assertThat(foundDoctor.getId()).isEqualTo(id);
        assertThat(1L).isEqualTo(id);
    }

    @Test
    public void givenEmailWhenFindByEmail() {
        System.out.println("Testing Email...");
        System.out.println("Before each test: " + doctorsRepo.findAll().size());

        String email = "crystal@mail.com";
        Doctor foundDoctor = doctorsRepo.findByEmail(email).get();
        assertThat(foundDoctor.getEmail()).isEqualTo(email);
    }

}



