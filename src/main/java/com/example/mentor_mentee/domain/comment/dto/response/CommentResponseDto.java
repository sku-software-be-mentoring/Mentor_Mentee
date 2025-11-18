package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private final long commentId;
    private final String body;
}

/*git status
git add .
git commit -m "?"
git push origin main*/