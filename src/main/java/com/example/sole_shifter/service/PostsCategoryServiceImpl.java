package com.example.sole_shifter.service;

import com.example.sole_shifter.dao.PostDao;
import com.example.sole_shifter.model.Post;
import com.example.sole_shifter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsCategoryServiceImpl implements PostsCategoryService{
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostDao postDao;

    public List<Post> getLatest() {
        return postRepository.getByOrderByWriteDateDesc();
    }

    public Post getOneLatestPost() {
        List<Post> list = postRepository.getByOrderByWriteDateDesc();
        return list.get(0);
    }

    public List<Post> getPopular() {
        List<Post> list = new ArrayList<>();
        try {
            list = postDao.getPopular();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Post getOnePopular() {
        List<Post> list = null;
        try {
            list = postDao.getPopular();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return list.get(0);
    }
}
