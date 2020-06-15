package com.example.sole_shifter.dao;

import com.example.sole_shifter.connection.ConnectionUtil;
import com.example.sole_shifter.model.Post;
import com.example.sole_shifter.model.type.PostType;
import com.example.sole_shifter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostDaoImpl implements PostDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Post> getPopular() throws SQLException, ClassNotFoundException {
        List<Post> posts = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        String sqlRequest = "SELECT p.*,\n" +
                "(0.33*(SELECT count(*) from post_likers where post_id = p.id) + (SELECT count(*) from comment where post_id = p.id)\n" +
                "/exp(TIMESTAMPDIFF(DAY, p.write_date, NOW())/7)) as popularity \n" +
                "FROM post p\n" +
                "ORDER BY popularity DESC LIMIT 8";
        ResultSet resultSet = statement.executeQuery(sqlRequest);
        while (resultSet.next()) {
            posts.add(Post.builder()
            .id(Long.valueOf(resultSet.getString("id")))
            .title(resultSet.getString("title"))
            .content(resultSet.getString("content"))
            .postType(PostType.valueOf(resultSet.getString("post_type")))
            .build());
        }
        return posts;
    }

}
