// Required package modules
package org.crystalowusu.springclinicmgmt.models;

// Importing required classes
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

//Lombok and Data JPA Annotations
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthGroup { // Class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull
    String email;

    @NonNull
    String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthGroup authGroup)) return false;
        return id == authGroup.id && email.equals(authGroup.email) && role.equals(authGroup.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, role);
    }
}