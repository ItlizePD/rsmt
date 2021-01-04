package com.itlize.microservice.auth.repository;


import com.itlize.microservice.auth.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
