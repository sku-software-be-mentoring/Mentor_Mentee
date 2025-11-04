package com.example.mentor_mentee.domain.post.repository;
import com.example.mentor_mentee.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 비워도 됨
}
