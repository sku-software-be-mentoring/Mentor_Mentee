package com.example.mentor_mentee.domain.user.entity;

import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.user.dto.request.PatchRequestDto;
import com.example.mentor_mentee.domain.user.enums.Field;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "classNum")
    private String classNum;

    @Column(name="email")
    private String email;

    @Column(name="loginId")
    private String loginId;

    @Column(name="password")
    private String password;

    @Column(name="department")
    private String department;

    @Column(name="inSchool")
    private boolean inSchool;

    @OneToMany(mappedBy = "user") // OneToMany는 지연로딩이 디폴트, cascade 설정도 해줘야됨. orphanRemoval 도 해야됨
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    // 사용자 정보를 수정하는 함수
    public void patchInfo(PatchRequestDto dto){
        switch (dto.getField()){
            case Field.NICKNAME:
                this.nickname = dto.getValue();
                break;
            case Field.EMAIL:
                this.email = dto.getValue();
                break;
            case Field.DEPARTMENT:
                this.department = dto.getValue();
                break;
            case Field.PASSWORD:
                this.password = dto.getValue();
                break;
        }
    }

    // 비밀번호 인코딩하는 함수
    public void encodePassword(PasswordEncoder encoder){
        this.password = encoder.encode(this.password);
    }
}
