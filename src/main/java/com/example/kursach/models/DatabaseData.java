package com.example.kursach.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseData {
    private Map<String, List<?>> entities;

    public DatabaseData() {
        entities = new HashMap<>();
    }

    public void addEntity(String entityName, List<?> entityData) {
        entities.put(entityName, entityData);
    }

    public Map<String, List<?>> getEntities() {
        return entities;
    }
}