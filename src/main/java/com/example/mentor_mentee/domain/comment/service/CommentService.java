package com.example.mentor_mentee.domain.comment.service;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        // 1. Comment 클래스 객체 생성
        Comment comment = Comment.builder()
                .userid(commentRequestDto.getUserid())
                .content(commentRequestDto.getContent())
                .build();

        // 2. 주입된 commentRepository 객체로 저장
        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .userid(savedComment.getUserid())
                .content(savedComment.getContent())
                .build();

    }
}
