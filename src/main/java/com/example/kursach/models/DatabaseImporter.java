package com.example.kursach.models;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class DatabaseImporter {
    private final ObjectMapper objectMapper;
    private final EntityManager entityManager;

    @Autowired
    public DatabaseImporter(ObjectMapper objectMapper, EntityManager entityManager) {
        this.objectMapper = objectMapper;
        this.entityManager = entityManager;
    }

    @Transactional
    public void importDatabaseFromJson(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            DatabaseData databaseData = objectMapper.readValue(inputStream, DatabaseData.class);
            databaseData.getEntities().forEach((entityName, entities) -> {
                Class<?> entityClass = resolveEntityClass(entityName);
                entities.forEach(entity -> entityManager.persist(entityClass.cast(entity)));
            });

            // Получение доступа к импортированным сущностям
            Map<String, List<Object>> importedEntities = databaseData.getEntities();

            //processImportedData(importedEntities);
        }
    }

    private Class<?> resolveEntityClass(String entityName) {
        try {
            // Полный путь к базовому пакету, в котором находятся ваши классы сущностей
            String basePackage = "com.example.kursach.models";
            String className = basePackage + "." + entityName;
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}