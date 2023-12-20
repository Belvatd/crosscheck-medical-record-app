package com.app.architecture.service;

import com.app.architecture.entity.User;
import com.app.architecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    //region
    private final UserRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //endregion

    /**
     * Get user by id
     *
     * @param id as String
     * @return User
     */
    public User getUserById(String id) {
        return repository.getUserByUserId(id);
    }

    /**
     * Save user
     *
     * @param user as User
     * @return User
     */
    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//        return repository.findAll();
    }
}
