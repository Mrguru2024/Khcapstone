package com.keycodehelp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final String LOGIN_URL = "/backend/src/main/resources/templates/login.html";
    private static final String HOME_URL = "/backend/src/main/resources/templates/home.html";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", LOGIN_URL, "/oauth2/**").permitAll()  // Publicly accessible
                .anyRequest().authenticated()  // Other URLs require authentication
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage(LOGIN_URL)  // Custom login page for OAuth2 login
                .defaultSuccessUrl(HOME_URL, true)  // Redirect to home after successful login
            )
            .logout(logout -> logout
                .logoutSuccessUrl(LOGIN_URL)  // Redirect to login page after logout
            );
        
        return http.build();
    }
}
