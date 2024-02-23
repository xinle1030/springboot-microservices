package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// extends JpaRepository to make this interface the repository layer
// provide entity type and primary key type

// by extending the class, this repository automatically has all the CRUD operations to perform on User JPA entity
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
