package com.app.architecture.repository;

import com.app.architecture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * SQL query: SELECT * FROM users WHERE citizensId =
     *
     * @param citizensId as String
     * @return User
     */
    User getUserByCitizensId(String citizensId);
}