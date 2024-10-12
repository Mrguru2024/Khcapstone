package com.keycodehelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keycodehelp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can go here
}
