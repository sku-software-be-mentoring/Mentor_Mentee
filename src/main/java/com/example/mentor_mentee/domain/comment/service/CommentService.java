package com.example.mentor_mentee.domain.comment.service;

import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto){
        Comment comment = Comment.builder()
                .body(commentRequestDto.getBody())
                .build();

        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .body(savedComment.getBody())
                .build();
    }
}
