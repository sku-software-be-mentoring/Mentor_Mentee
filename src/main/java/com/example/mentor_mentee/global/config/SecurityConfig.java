package com.example.mentor_mentee.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                request ->
                    request
                        // /api 경로로 들어오는 모든 요청은 허락
                        .requestMatchers("/api/**")
                        .permitAll()
                        // 그 외 모든 요청은 인증 필요
                        .anyRequest()
                        .authenticated()
            )
            .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
