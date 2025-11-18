package com.example.mentor_mentee.domain.comment.entity;

import com.example.mentor_mentee.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", nullable=false,length=300)
    private String body;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable=false)
    private Post post;
}
