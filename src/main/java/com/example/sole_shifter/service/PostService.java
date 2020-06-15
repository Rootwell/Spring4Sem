package com.example.sole_shifter.service;

import com.example.sole_shifter.dto.PostDto;

public interface PostService {
    public void addNewPost(Long userId, PostDto form);
    public void likePost(Long postId, Long userId);
    public boolean isPostLikedByUser(Long postId, Long userId);
}
