package com.example.mentor_mentee.domain.comment.dto.response;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class CommentResponseDto {
    private final Long commentId;
    private final String body;
}
