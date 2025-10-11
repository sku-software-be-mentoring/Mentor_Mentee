package com.example.mentor_mentee.domain.comment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 본문
    @Column(name = "body", nullable = false, length = 300)
    private String body;

    // 댓글을 적은 사용자 정보

    // 댓글 좋아요

    // 댓글 싫어요
}
