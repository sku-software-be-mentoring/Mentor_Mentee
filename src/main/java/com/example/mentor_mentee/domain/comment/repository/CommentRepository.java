package com.example.mentor_mentee.domain.comment.repository;

import com.example.mentor_mentee.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // userid로 모든 comment 찾기
    List<Comment> findByUserid(String userid);

    // 내용으로 모든 comment 찾기
    List<Comment> findByContent(String content);

}
