package com.keycodehelp.repositories;

import com.keycodehelp.entities.KeycodeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeycodeRequestRepository extends JpaRepository<KeycodeRequest, Long> {
    // Additional custom queries can go here
}
