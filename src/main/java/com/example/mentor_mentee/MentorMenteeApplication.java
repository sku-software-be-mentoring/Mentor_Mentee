package com.example.mentor_mentee;

import com.example.mentor_mentee.domain.post.repository.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MentorMenteeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentorMenteeApplication.class, args);
    }
}
