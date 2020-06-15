package com.example.sole_shifter.dao;

import com.example.sole_shifter.model.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDao {
    List<Post> getPopular() throws SQLException, ClassNotFoundException;
}
