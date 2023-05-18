package com.example.kursach.models;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DatabaseImporter {
    @Autowired
    private ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void importDatabaseFromJson(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            DatabaseData databaseData = objectMapper.readValue(inputStream, DatabaseData.class);
            databaseData.getEntities().forEach((entityName, entities) -> {
                entities.forEach(entity -> entityManager.persist(entity));
            });
        }
    }
}