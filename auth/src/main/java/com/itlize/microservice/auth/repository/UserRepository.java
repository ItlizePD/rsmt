package com.itlize.microservice.auth.repository;

import com.itlize.microservice.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

    @Query("select u from User u where u.username = ?#{principal.username}")
    User findCurrentUserInformation();
}

