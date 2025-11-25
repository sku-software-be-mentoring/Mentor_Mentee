package com.example.mentor_mentee.domain.user.dto.response;

import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserPostResponseDto {
    private final Long id;
    private final List<PostResponseDto> posts;
}
