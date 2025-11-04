package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;

@Builder
public class CommentResponseDto {
    private final long commentId;
    private final String body;
}
