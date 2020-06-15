package com.example.sole_shifter.service;

import com.example.sole_shifter.dto.PostDto;
import com.example.sole_shifter.model.Post;
import com.example.sole_shifter.model.User;
import com.example.sole_shifter.model.type.PostType;
import com.example.sole_shifter.repository.PostRepository;
import com.example.sole_shifter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void addNewPost(Long userId, PostDto form) {
        User user = userRepository.getOne(userId);
        Post post = Post.builder()
                .author(user)
                .content(form.getContent())
                .title(form.getTitle())
                .writeDate(LocalDateTime.now())
                .postType(PostType.valueOf(form.getPostType()))
                .build();
        postRepository.save(post);
    }

    public void likePost(Long postId, Long userId) {
        Post post = postRepository.getOne(postId);
        User user = userRepository.getOne(userId);
        Set<User> likers = post.getLikers();
        Set<Post> likedPosts = user.getLiked();
        if (isPostLikedByUser(postId, userId)) {
            likers.remove(user);
            likedPosts.remove(post);
        } else {
            likers.add(user);
            likedPosts.add(post);
        }
        user.setLiked(likedPosts);
        post.setLikers(likers);
        userRepository.save(user);
        postRepository.save(post);
    }

    public boolean isPostLikedByUser(Long postId, Long userId) {
        Post post = postRepository.getOne(postId);
        User user = userRepository.getOne(userId);
        return post.getLikers().contains(user);
    }
}
