package com.example.mentor_mentee.domain.comment.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.service.CommentService;
import com.example.mentor_mentee.global.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService ;

    @PostMapping("/{post-id}")
    public ResponseEntity<BaseResponse<CommentResponseDto>> createComment(@PathVariable(value = "post-id") Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto responseDto = commentService.createComment(postId, commentRequestDto);
        return ResponseEntity.status(201).body(BaseResponse.success(201, "댓글이 성공적으로 생성되었습니다.", responseDto));
    }

    @DeleteMapping("/{post-id}/{comment-id}")
    public ResponseEntity<BaseResponse<Void>> deleteComment(@PathVariable(value = "post-id") Long postId, @PathVariable(value = "comment-id") Long commentId){
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.status(200).body(BaseResponse.success(200, "댓글이 성공적으로 삭제되었습니다.", null));
    }
}
