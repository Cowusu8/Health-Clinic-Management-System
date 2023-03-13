//package org.crystalowusu.springclinicmgmt.dao;
//
//
//import org.crystalowusu.springclinicmgmt.models.Doctor;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class DoctorsRepoTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    private DoctorsRepo doctorsRepo;
//
//    @Test
//    void deleteDoctorById(); {
//
//        //Given
//        Doctor doctor = new Doctor(id 1);
//        entityManager.persist(doctor);
//        entityManager.flush();
//
//        //When
//        Optional<Doctor> deleteDoctorById = doctorsRepo.deleteDoctorById(long id);
//
//        //Then
//        assertThat(found.get().getEmail()).isEqualTo(doctor.getEmail());
//    }
//}
//
//
//
