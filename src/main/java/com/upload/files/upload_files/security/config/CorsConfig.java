package com.upload.files.upload_files.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // Permitir todas as origens (use com cuidado)
        config.setAllowedOrigins(Arrays.asList("*"));
        
        // Permitir todos os métodos HTTP
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Permitir todos os cabeçalhos
        config.setAllowedHeaders(Arrays.asList("*"));
        
        // Opcional: Expor certos cabeçalhos
        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Disposition"));
        
        // Não permitir o envio de credenciais (cookies, etc.)
        config.setAllowCredentials(false);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
