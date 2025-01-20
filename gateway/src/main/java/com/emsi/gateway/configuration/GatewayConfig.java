package com.emsi.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GatewayConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://localhost:3000");  // Allow your frontend origin
        corsConfig.addAllowedMethod("*");  // Allow all methods (GET, POST, etc.)
        corsConfig.addAllowedHeader("*");  // Allow all headers
        corsConfig.setAllowCredentials(true);  // Allow credentials if needed

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);  // Apply CORS config to all routes

        return new CorsFilter(source);
    }
}
