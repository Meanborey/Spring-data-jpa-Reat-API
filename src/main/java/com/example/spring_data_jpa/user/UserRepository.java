package com.example.spring_data_jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findById(long Id);

//    int deleteAllById(long id); // This method is not implemented in the UserRepository interface
}
