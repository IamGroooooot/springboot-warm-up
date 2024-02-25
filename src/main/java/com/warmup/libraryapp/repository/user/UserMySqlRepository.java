package com.warmup.libraryapp.repository.user;

import com.warmup.libraryapp.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMySqlRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUser(String name, int age) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    @Override
    public boolean isUserExist(Long id) {
        String sql = "SELECT COUNT(*) FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, id) > 0;
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    return new User(id, name, age);
                });
    }
}
