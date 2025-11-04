package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private final Long id;
    private final String author;
    private final String content;
    private final Long views;
}
