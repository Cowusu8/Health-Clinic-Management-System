// Required package modules
package org.crystalowusu.springclinicmgmt.models;

// Importing required classes
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;

//Lombok and Data JPA Annotations
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@Table(name="Admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin { // Class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull
    String Email;

    @NonNull
    String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        return id == admin.id && Email.equals(admin.Email) && password.equals(admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Email, password);
    }
}