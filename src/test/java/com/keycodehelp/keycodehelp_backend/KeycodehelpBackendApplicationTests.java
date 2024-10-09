package com.keycodehelp.keycodehelp_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Ensure it uses the 'application-test.properties'
class KeycodehelpBackendApplicationTests {

    @Test
    void contextLoads() {
        // This test verifies if the Spring Application Context loads properly
    }
}
