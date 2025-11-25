package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.post.dto.request.CreateRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostListResponseDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 생성자 자동생성 | 생성자가 하나만 있다면 @autowired 자동진행
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public  PostResponseDto createPost(@RequestBody CreateRequestDto createRequestDto){
        PostResponseDto responseDto = postService.createPost(createRequestDto);
        return responseDto;
    }
    // 사실 DB 등록 코드이기에 void도 가능하지만, 데이터 반환뿐만 아니라 성공신호등도 반환받아야함.
    // 따라서 void 보다는 ResponseEntity<PostResponseDto> 같이 성공신호등의 정보 정도는 반환해주어야함.

    @PostMapping("/{user-id}")
    public PostResponseDto createPost_user(@PathVariable(value = "user-id") Long userId, @RequestBody CreateRequestDto postRequestDto){
        PostResponseDto responseDto = postService.createPost_user(userId, postRequestDto);
        return responseDto;
    }

    @GetMapping
    public List<PostListResponseDto> getAllPosts() {
        List<PostListResponseDto> responseDtos = postService.readPostList();
        return responseDtos;
    }

    @GetMapping("/{post-id}") // url에서는 get 요청밖에 못함
    public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id){
        PostResponseDto responseDto = postService.readPost(id);
        return responseDto;
    }

    @PutMapping("/{post-id}")
    public PostResponseDto updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
        return responseDto;
    }

    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable(value = "post-id") Long id){
        String response = postService.deletePost(id);
        return response;
    }
}
