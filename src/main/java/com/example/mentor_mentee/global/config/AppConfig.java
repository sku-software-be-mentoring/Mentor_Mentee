package com.example.mentor_mentee.global.config;

// 전체적인 설정을 위한 폴더 Global

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 아래 클래스는 Bean을 등록하는 클래스다.
public class AppConfig {

    @Bean
    public String appName() {
        return "Memtor Mentee";
    }

    @Bean
    public String myName(){
        return "Junyong";
    }

    @Bean
    public Integer myAge(){
        return 24;
    }
}
