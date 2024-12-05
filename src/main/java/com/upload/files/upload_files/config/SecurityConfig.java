package com.upload.files.upload_files.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth ->
                auth.requestMatchers("/auth").permitAll()
                    .requestMatchers("/file/download/**").permitAll()
                    .requestMatchers("/swagger-ui/**").permitAll()
                    .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()) 
            .oauth2ResourceServer(oauth2 -> 
                oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
    
    @Bean
    JwtDecoder jwtDecode(){

    }
}
