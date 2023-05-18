package com.example.kursach.controllers;

import com.example.kursach.services.CategService;
import com.example.kursach.services.InstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CategController {
    private final CategService categService;
    private final InstService instService;
    @GetMapping("/")
    public String mainPage (Principal principal, Model model)
    {
        model.addAttribute("category", categService.listReturn());
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        return "mainPage";
    }
}
