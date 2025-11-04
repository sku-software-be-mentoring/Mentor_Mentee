package com.example.mentor_mentee.domain.comment.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentRequestDto {

    private final String author;
    private final String comment;

}
