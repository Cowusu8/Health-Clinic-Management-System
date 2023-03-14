package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        class AdminRepoITest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdminRepoI adminRepoI;


    //@Test
    void findByEmailAllIgnoreCase() {
        //Given
        Admin admin = new Admin("admin@mail.com", "password");
        entityManager.persist(admin);
        entityManager.flush();

        //When
        Optional<Admin> found = adminRepoI.findByEmailAllIgnoreCase(admin.getEmail());

        //Then
        assertThat(found.get().getEmail()).isEqualTo(admin.getEmail());
    }


}