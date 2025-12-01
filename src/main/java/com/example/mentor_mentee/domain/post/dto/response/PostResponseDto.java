package com.example.mentor_mentee.domain.post.dto.response;

import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
public class PostResponseDto {
  private final Long id;
  private final String title;
  private final String content;
  private final Integer commentCount;
  private final List<CommentResponseDto> comments;
}
