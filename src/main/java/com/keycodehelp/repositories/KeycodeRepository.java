package com.keycodehelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keycodehelp.entities.Keycode;

@Repository
public interface KeycodeRepository extends JpaRepository<Keycode, Long> {
    // Additional custom queries can go here
}
