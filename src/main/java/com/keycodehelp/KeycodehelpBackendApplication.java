package com.keycodehelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.keycodehelp")
public class KeycodehelpBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(KeycodehelpBackendApplication.class, args);
    }
}
