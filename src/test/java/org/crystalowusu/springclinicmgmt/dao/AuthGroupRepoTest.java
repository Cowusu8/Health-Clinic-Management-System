package org.crystalowusu.springclinicmgmt.dao;


import org.crystalowusu.springclinicmgmt.models.AuthGroup;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthGroupRepoTest {

    @Autowired
    AuthGroupRepoI authGroupRepoI;

    private AuthGroup authGroup;

    @BeforeEach
    void setup() {
        System.out.println("Before each test: " + authGroupRepoI.findAll().size());
        authGroup = new AuthGroup();
        authGroup.setEmail("crystal@mail.com");
        authGroup.setRole("ADMIN");
        authGroupRepoI.save(authGroup);
    }
    @Test
    public void givenEmailWhenFindByEmail() {
        System.out.println("Testing Email...");
        System.out.println("Before each test: " + authGroupRepoI.findAll().size());

        String email = "crystal@mail.com";
        AuthGroup foundAuthGroup = authGroupRepoI.findByEmail(email).get(0);
        assertThat(foundAuthGroup.getEmail()).isEqualTo(email);
    }
}
