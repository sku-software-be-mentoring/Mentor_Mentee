package com.example.mentor_mentee.domain.users.repository;
import com.example.mentor_mentee.domain.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
