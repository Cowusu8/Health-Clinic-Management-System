package org.crystalowusu.springclinicmgmt.dao;


import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorsRepoTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private DoctorsRepo doctorsRepo;

    private Doctor firstDoctor;

    @BeforeEach
    void setup(){
        System.out.println("Before each test: " + doctorsRepo.findAll().size() );

        firstDoctor.setEmail("firstdoctor@test.com");
        firstDoctor.setFullName("First doctor");
        firstDoctor.setBirthDate("2202");
        firstDoctor.setGender("M");
        firstDoctor.setPhone("792");
        firstDoctor.setAddress("231 street ave");
        doctorsRepo.save(firstDoctor);
    }

    @Test
    public void givenIdWhenFindByID(){
        System.out.println("Testing id...");
        Long id = 1L;
        Doctor foundDoctor = doctorsRepo.findById(id).get();
        assertThat(foundDoctor.getId()).isEqualTo(id);
    }


}



