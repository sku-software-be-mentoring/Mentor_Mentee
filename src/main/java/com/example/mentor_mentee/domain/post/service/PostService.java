package com.example.mentor_mentee.domain.post.service;
import com.example.mentor_mentee.domain.post.dto.request.CreateRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(CreateRequestDto createRequestDto) {
        // 1. PostRequestDto에 있는 값으로 post 클래스 객체 생성
        Post post = Post.builder()
                .title(createRequestDto.getTitle())
                .content(createRequestDto.getContent())
                .build();

        // 2. 새로 생성한 post 객체 DB에 저장
        Post savedPost = postRepository.save(post);

        // 3. 새로 생성한 post 객체 데이터에서 필요한 부분을 PostResponseDto에 넣어서 PostResponseDto 객체 생성
        return PostResponseDto.builder()
                .id(savedPost.getId())
                .title(savedPost.getTitle())
                .content(savedPost.getContent())
                .views(savedPost.getViews())
                .build();
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(Long id){
        Post getPost = postRepository.findById(id).orElse(null);

        return PostResponseDto.builder()
                .id(getPost.getId())
                .title(getPost.getTitle())
                .content(getPost.getContent())
                .views(getPost.getViews())
                .build();
    }

    @Transactional
    public PostResponseDto updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId) {
        // 1. postId를 통해서 Post 조회, 예외 처리 필요
        Post post = postRepository.findById(postId).orElse(null);

        // 2. 해당 post의 값을 변경
        post.update(updatePostRequestDto.getTitle(), updatePostRequestDto.getContent());

        // 3. postResponseDto에 해당 Post 내용을 담아서 반환
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .views(post.getViews())
                .build();
    }
    // JPA 는 DB에서 본인 캐시메모리에 필요한 데이터 객체를 할당한다.
    // 따라서 DB에서 가져온 객체를 수정하면, 일단 JPA 안의 객체를 수정한다.
    // 함수 종료후 캐시메모리 안의 객체를 DB로 반환한다.
    // 영속성 컨텍스트

    @Transactional
    public String deletePost(Long postId) {
        // 1. postId를 통해서 해당 Post 존재 여부 조회, 존재 여부에 따라 삭제 조건문 필요
        if(postRepository.existsById(postId)){
            postRepository.deleteById(postId);
            return postId + "번 게시글 삭제 완료";
        } else {
            return postId + "번 게시글이 존재하지 않습니다.";
        }
    }
}