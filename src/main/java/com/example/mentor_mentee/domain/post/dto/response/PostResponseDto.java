package com.example.mentor_mentee.domain.post.dto.response;


import com.example.mentor_mentee.domain.post.repository.PostRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Long views;
}
