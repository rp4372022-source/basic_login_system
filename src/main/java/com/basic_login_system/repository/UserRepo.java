package com.basic_login_system.repository;

import com.basic_login_system.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    private final JdbcTemplate template;

    // Best Practice: Use constructor injection instead of field @Autowired
    public UserRepo(JdbcTemplate template) {
        this.template = template;
    }

    public List<User> getAllUsers(){
        String query = "SELECT * FROM user_data;";

        return template.query(query, (rs ,rowNum) -> {
            return new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")

            );
        }); 

    }
    public void addUser(User user){
        // Safe strategy: Escape column names to prevent reserved keyword conflicts
        String query = "INSERT INTO user_data(`name`,`email`,`password`) VALUES (?,?,?);";

        int rows = template.update(query, user.getName(), user.getEmail(), user.getPassword());
        System.out.println(rows + " rows affected");
    }

    public User findUserByName(String userName){
        String query = "SELECT * FROM user_data WHERE `name` = ?;";

        try {
            return template.queryForObject(query, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
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
        // FIX: Changed 'WHERE name = ?' to 'WHERE email = ?'
        String query = "SELECT * FROM user_data WHERE `email` = ?;";

        try {
            return template.queryForObject(query, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
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
