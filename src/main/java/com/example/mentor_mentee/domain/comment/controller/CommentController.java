package com.example.mentor_mentee.domain.comment.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import com.example.mentor_mentee.domain.comment.service.CommentService;import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto responseDto = commentService.createComment(commentRequestDto);
        return responseDto;
    }

    @GetMapping
    public String getAllByComments() {
        return "댓글 리스트 조회 완료";
    }

    @GetMapping("/{comment-id}")
    public String getCommentById(@PathVariable(value = "comment-id") Long commentId) {
        return "comment-id로 댓글 조회 완료: " + commentId.toString();
    }

    @PutMapping("/{comment-id}")
    public String updateComment(@PathVariable(value = "comment-id") Long commentId) {
        return "comment-id로 댓글 수정 완료: " + commentId.toString();
    }

    @DeleteMapping("/{comment-id}")
    public String deleteComment(@PathVariable(value = "comment-id") Long commentId) {
        return "comment-id로 댓글 삭제 완료: " + commentId.toString();
    }
}
