package com.example.mentor_mentee.domain.comment.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @PostMapping("/")
    public String createComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentRequestDto.getAuthor() + ": " + commentRequestDto.getComment() + "댓글 생성 완료";
    }

    @GetMapping
    public String getAllComments() {
        return "댓글 리스트 조회 완료";
    }

    @GetMapping("/{comment-id}")
    public String getPostById(@PathVariable(value = "comment-id") Long id) {
        return id + "번 댓글 조회 완료";
    }

    @PutMapping("/{comment-id}")
    public String updatePost(@PathVariable(value = "comment-id") Long id) {
        return id + "번 댓글 수정 완료";
    }

    @DeleteMapping("/{comment-id}")
    public String deletePost(@PathVariable(value = "comment-id") Long id){
        return id + "번 댓글 삭제 완료";
    }

}