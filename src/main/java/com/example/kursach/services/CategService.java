package com.example.kursach.services;

import com.example.kursach.models.Category;
import com.example.kursach.repositories.CategRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategService {
    private final CategRepository categRepository;

    public List<Category> listReturn() {
        return categRepository.findAll();
    }
    public Category getCategById(Long idCateg) {return categRepository.findById(idCateg).orElse(null);}
}

