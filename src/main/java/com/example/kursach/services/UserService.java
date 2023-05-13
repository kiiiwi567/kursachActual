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

    public String createUser(User user) {
        String userEmail = user.getUserEmail();
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) return "emailTaken";
        if (userRepository.findByUserPhone(user.getUserPhone()) != null) return "phoneTaken";
        user.setActive(true);
        user.getRoles().add(Role.ROLE_CLIENT);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return "0";
    }
}