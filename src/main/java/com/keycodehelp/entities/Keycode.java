package com.keycodehelp.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "keycode")
public class Keycode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    @Column(nullable = false)
    private String keycode;

    @Column(nullable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors, Getters, and Setters

    public Keycode() {}

    public Keycode(String vin, String keycode, Date createdAt, User user) {
        this.vin = vin;
        this.keycode = keycode;
        this.createdAt = createdAt;
        this.user = user;
    }

    // Getters and setters here...
}
