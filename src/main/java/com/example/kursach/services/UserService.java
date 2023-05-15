package com.example.kursach.services;


import com.example.kursach.models.User;
import com.example.kursach.models.enums.Role;
import com.example.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()){
                user.setActive(false);
                log.info("Banned user with id={}, email={}", user.getIdUser(), user.getUserEmail());
            } else {
                user.setActive(true);
                log.info("Unbanned user with id={}, email={}", user.getIdUser(), user.getUserEmail());
            }
        }
        userRepository.save(user);
    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }


}