package com.example.kursach.services;

import com.example.kursach.models.Category;
import com.example.kursach.models.Image;
import com.example.kursach.models.Instrument;
import com.example.kursach.repositories.CategRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategService {
    private final CategRepository categRepository;

    public List<Category> listReturn() {
        return categRepository.findAll();
    }
}

