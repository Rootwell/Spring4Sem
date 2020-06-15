package com.example.sole_shifter.repository;

import com.example.sole_shifter.model.Post;
import com.example.sole_shifter.model.type.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    List<Post> getAllByAuthor_Id(Long id);
    List<Post> getAllByPostType(PostType postType);
    List<Post> getByOrderByWriteDateDesc();
}
