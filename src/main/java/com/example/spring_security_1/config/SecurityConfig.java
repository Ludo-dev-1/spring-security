package com.example.spring_security_1.config;// warning: package omitted

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        // Route publique
                        .requestMatchers("/").permitAll()
                        // Accessible uniquement aux utilisateurs
                        .requestMatchers("/profile/**").hasAuthority("ROLE_USER")
                        // Accessible uniquement aux admins
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                        // Les autres routes sont sécurisées
                        .anyRequest().authenticated())
                // Authentification par formulaire
                .formLogin(Customizer.withDefaults())
                // Création d'une page /logout de déconnexion
                .logout(Customizer.withDefaults())
                .build();
    }
}