package com.example.kursach.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Component
public class DatabaseExporter {
    @Autowired
    private ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void exportDatabaseToJson(String outputPath) throws IOException {
        DatabaseData databaseData = new DatabaseData();
        entityManager.getMetamodel().getEntities().forEach(entityType -> {
            String entityName = entityType.getName();
            databaseData.addEntity(entityName, entityManager.createQuery("SELECT e FROM " + entityName + " e").getResultList());
        });

        objectMapper.writeValue(new File(outputPath), databaseData);
    }
}
