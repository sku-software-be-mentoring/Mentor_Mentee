package com.example.mentor_mentee.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String appName() {
        return  "Mentor Mentee";
    }

    @Bean
    public String myName() {
        return  "Jeongwon";
    }

    @Bean
    public Integer myAge() {
        return  21;
    }

}
