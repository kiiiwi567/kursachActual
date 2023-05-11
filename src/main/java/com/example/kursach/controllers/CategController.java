package com.example.kursach.controllers;

import com.example.kursach.services.CategService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CategController {
    private final CategService categService;
    @GetMapping("/")
    public String mainPage (Model model)
    {
        model.addAttribute("category", categService.listReturn());
        return "mainPage";
    }
}
