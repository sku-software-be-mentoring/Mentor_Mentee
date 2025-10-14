package com.example.mentor_mentee.domain.post.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity                 //이 클래스를 테이블과 매핑되는 엔티티로 인식하게
@Getter
@Builder                //빌더 패턴을 자동 생성해 가독성 있게 객체 생성
@AllArgsConstructor     //모든 필드를 매개변수로 받는 전체 생성자 자동생성
@NoArgsConstructor      //매개변수 없는 기본 생성자 자동 생성
@Table(name= "post")    //엔티티가 매핑될 테이블 이름 지정
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //순번

    @Column(nullable = false)
    private String title;   //제목

    @Column(nullable = false)
    private String content; //내용

    @Column(nullable = false)
    @Builder.Default        //@Builder 사용 시 필드 기본 값 유지하도록 지정
    private Long views = 0L; //조회수
}
