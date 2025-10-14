package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController  //해당 클래스가 Web 요청을 담당하는 컨트롤러 기능을 수행
@RequestMapping("/api/posts")  //요청 기본 엔드포인트(url)를 지정
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto responseDto = postService.createPost(postRequestDto);
        return responseDto;
    }

    @GetMapping
    public String getAllPosts(){
        return "게시글 리스트 조회 완료";
    }

    @GetMapping("/{post-id}") //얘네는 get에서 직접 받아서 하는거라 데이터를 직접 처리하는거라서 url에서 뜨면 안돼!
    public String getPostById(@PathVariable("post-id") Long id){
        return id + "번 게시글 조회 완료";
    }

    @PutMapping("/{post-id}")
    public String updatePost(@PathVariable("post-id") Long id){
        return id + "번 게시글 수정 완료";
    }

    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable("post-id") Long id){
        return id + "번 게시글 삭제 완료";
    }
}
