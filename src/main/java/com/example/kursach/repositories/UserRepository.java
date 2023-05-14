package com.example.kursach.repositories;

import com.example.kursach.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);
    User findByUserPhone(String userPhone);
    User findByUserName(String username);
}
