package com.example.mentor_mentee.domain.comment.repository;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.swing.text.html.Option;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
