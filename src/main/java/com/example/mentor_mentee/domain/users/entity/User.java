package com.example.mentor_mentee.domain.users.entity;
import com.example.mentor_mentee.domain.users.dto.PatchRequestDto;
import com.example.mentor_mentee.domain.users.enums.Field;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부에서 new User
@Table(name = "user")
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


    // 사용자 정보를 수정하는 함수
    public void patchInfo(PatchRequestDto dto){
        switch (dto.getField()){
            case NICKNAME:
                this.nickname = dto.getValue();
                break;
            case EMAIL:
                this.email = dto.getValue();
                break;
            case DEPARTMENT:
                this.department = dto.getValue();
                break;
            case PASSWORD:
                this.password = dto.getValue();
                break;
        }
    }

    // 비밀번호 인코딩하는 함수
    public void encodePassword(PasswordEncoder encoder){
        this.password = encoder.encode(this.password);
    }
}
