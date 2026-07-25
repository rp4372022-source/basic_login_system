package com.basic_login_system.repository;

import com.basic_login_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepo {

    private JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate){
        this.template = jdbcTemplate;
    }

    public void addUser(User user){
        String query = "INSERT INTO user_data(name,email,password) VALUES (?,?,?);";

        int rows = template.update(query,user.getName(),user.getEmail(),user.getPassword());

        System.out.println(rows+"rows affected");
    }

    public User findUserByName(String userName){
        String query = "SELECT * FROM user_data WHERE name = ?;";

        try {
            return template.queryForObject(query, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id")); // Maps 'user_id' column to 'id' property
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }, userName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findUserByEmail(String userEmail){
        String query = "SELECT * FROM user_data WHERE name = ?;";

        try {
            return template.queryForObject(query, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id")); // Maps 'user_id' column to 'id' property
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }, userEmail);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
