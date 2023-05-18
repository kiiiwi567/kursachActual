package com.example.kursach.controllers;

import com.example.kursach.models.User;
import com.example.kursach.services.InstService;
import com.example.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final InstService instService;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Principal principal, Model model) {
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (userService.createUser(user) == "emailTaken") {
            model.addAttribute("errorMessage", "Пользователь с таким email уже существует!");
            return "registration";
        }
        if (userService.createUser(user) == "phoneTaken") {
            model.addAttribute("errorMessage", "Пользователь с таким номером телефона уже существует!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model, Principal principal) {
        model.addAttribute("user", user);
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        return "userInfo";
    }

    @GetMapping("/user/profile")
    public String userInfo(Model model, Principal principal) {
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        return "userInfo";
    }
}