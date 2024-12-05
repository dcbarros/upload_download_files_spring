package com.upload.files.upload_files.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigProject {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desativa CSRF, se não necessário
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated() // Exige autenticação para todas as rotas
            )
            .formLogin().and() // Habilita autenticação via formulário
            .httpBasic(); // Habilita autenticação básica
        return http.build();
    }
}
