// Required package modules
package org.crystalowusu.springclinicmgmt.models;

// Importing required classes
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

//Lombok and Data JPA Annotations
@Entity
@Slf4j
@Setter
@Getter
@ToString
@Table(name="Admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String email;

    @Setter(AccessLevel.NONE)
    String password;

    public Admin() {}
    public Admin(String email, String password) {
        this.email = email;
        this.password = setPassword(password);
    }

    public Admin(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = setPassword(password);
    }

    public String setPassword(String password) {
        return this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        return id == admin.id && email.equals(admin.email) && password.equals(admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}