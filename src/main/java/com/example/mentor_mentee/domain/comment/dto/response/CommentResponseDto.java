package com.example.mentor_mentee.domain.comment.dto.response;

import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import lombok.Builder;
import lombok.Getter;

@Getter // jackson 라이브러리에서 dto => json 변환시 getter를 사용
@Builder
public class CommentResponseDto {
    private final Long id;
    private final String body;
}
