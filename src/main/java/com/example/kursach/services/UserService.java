package com.example.kursach.services;


import com.example.kursach.models.User;
import com.example.kursach.models.enums.Role;
import com.example.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String userEmail = user.getUserEmail();
        if (userRepository.findByUserEmail(userEmail) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_CLIENT);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return true;
    }
}