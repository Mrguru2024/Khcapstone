package com.keycodehelp.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "keycode_requests")
public class KeycodeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String requestDetails;

    @Column(nullable = false)
    private String vin;

    @Column(name = "request_time", nullable = false)
    private LocalDateTime requestTime;

    // Add other fields and getters/setters as needed
}
