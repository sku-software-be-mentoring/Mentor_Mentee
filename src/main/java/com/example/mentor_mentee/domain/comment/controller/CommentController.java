package com.example.mentor_mentee.domain.comment.controller;


import com.example.mentor_mentee.domain.comment.entity.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @PostMapping
    public String createComment(@RequestBody Comment comment) {
        return "댓글 생성 완료: " +comment.getBody();
    }

    @GetMapping
    public String getAllComments() {
        return "댓글 리스트 조회 완료";
    }

    @GetMapping("/{comment-id}")
    public String getCommentById(@PathVariable(value="comment-id") Long commentId) {
        return "comment-id로 댓글 조회 완료: " + commentId.toString();
    }

    @PutMapping("/{comment-id}")
    public String updateComment(@PathVariable(value = "comment-id") Long commentId) {
        return "comment-id로 댓글 수정 완료:" + commentId.toString();
    }

    @DeleteMapping("/{comment-id}")
    public String deleteComment(@PathVariable(value = "comment-id") Long commentId){
        return "comment-id로 댓글 삭제 완료:" + commentId.toString();
    }

}
