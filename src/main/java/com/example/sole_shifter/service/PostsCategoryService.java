package com.example.sole_shifter.service;

import com.example.sole_shifter.model.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostsCategoryService {
    List<Post> getLatest();
    Post getOneLatestPost();
    List<Post> getPopular();
    Post getOnePopular();
}
