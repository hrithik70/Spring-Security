package com.hrithik.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(e-> e.disable());
        http.formLogin(e-> e.disable());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(e->e.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();

    }
}
