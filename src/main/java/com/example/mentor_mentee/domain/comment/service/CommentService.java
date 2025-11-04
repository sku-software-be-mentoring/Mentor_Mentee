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

    public CommentResponseDto create(CommentRequestDto commentRequestDto) {
        // DTO -> Entity
        Comment comment = Comment.builder()
                .author(commentRequestDto.getAuthor())
                .content(commentRequestDto.getComment())
                .build();

        // DB 저장
        Comment savedComment = commentRepository.save(comment);

        // Entity -> Response DTO
        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .author(savedComment.getAuthor())
                .content(savedComment.getContent())
                .views(savedComment.getViews())
                .build();
    }
}
