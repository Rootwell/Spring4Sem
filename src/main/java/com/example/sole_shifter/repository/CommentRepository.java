package com.example.sole_shifter.repository;

import com.example.sole_shifter.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByPostId(Long postId);
}
