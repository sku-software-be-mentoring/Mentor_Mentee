package com.example.mentor_mentee.domain.post.entity;

import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post") // OneToMany는 지연로딩이 디폴트, cascade 설정도 해줘야됨. orphanRemoval 도 해야됨
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // FK 생성
    private User user;
}

// 내 브랜치에 업로드 git pull request
// PR 이후 Merge 해줘야함