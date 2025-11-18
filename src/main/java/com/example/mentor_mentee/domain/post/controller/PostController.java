package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostListResponseDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public PostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        PostResponseDto responseDto = postService.createPost(createPostRequestDto);
        return responseDto;
    }
    @GetMapping
    public List<PostListResponseDto> getAllPosts() {
        List<PostListResponseDto> responseDtos = postService.readPostList();
        return responseDtos;
    }

    @GetMapping("/{post-id}")
    public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id){
        PostResponseDto post = postService.findById(id);
        return post;
    }

    @PutMapping("/{post-id}")
    public PostResponseDto updatePost(@PathVariable(value = "post-id") Long id, @RequestBody UpdatePostRequestDto updatePostRequestDto){
        PostResponseDto post = postService.updatePost(updatePostRequestDto,id);
        return post;
    }
    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable(value = "post-id") Long id){
        return id+"번 게시글 삭제 완료";
    }
}
