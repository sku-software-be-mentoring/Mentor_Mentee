package com.example.mentor_mentee.domain.post.dto.response;


import lombok.*;

@Builder
public class PostResponseDto {
    private final long id;
    private final String title;
    private final String content;
    private final long views;
}
