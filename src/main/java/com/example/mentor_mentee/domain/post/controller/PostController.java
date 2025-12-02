package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostListResponseDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import com.example.mentor_mentee.global.base.BaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

  private final PostService postService;

  @PostMapping
  public ResponseEntity<BaseResponse<PostResponseDto>> createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
    PostResponseDto responseDto = postService.createPost(createPostRequestDto);
    return ResponseEntity.status(201).body(BaseResponse.success("201", "게시글이 성공적으로 생성되었습니다.", responseDto));
  }

  @GetMapping
  public ResponseEntity<BaseResponse<List<PostListResponseDto>>> getAllPosts() {
    List<PostListResponseDto> responseDtos = postService.readPostList();
    return ResponseEntity.status(200).body(BaseResponse.success(responseDtos));
  }

  @GetMapping("{/post-id}")
  public ResponseEntity<BaseResponse<PostResponseDto>> getPost(@PathVariable Long id) {
    PostResponseDto responseDto = postService.readPost(id);
    return ResponseEntity.status(200).body(BaseResponse.success(responseDto));
  }


  @PutMapping("/{post-id}")
  public ResponseEntity<BaseResponse<PostResponseDto>> updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto,
      @PathVariable(value = "post-id") Long id) {
    PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
    return ResponseEntity.status(200).body(BaseResponse.success(responseDto));
  }

  @DeleteMapping("/{post-id}")
  public ResponseEntity<BaseResponse<String>> deletePost(@PathVariable("post-id") Long id) {
    postService.deletePost(id);
    return ResponseEntity.status(200)
        .body(BaseResponse.success("게시글이 성공적으로 삭제되었습니다."));
  }


}
