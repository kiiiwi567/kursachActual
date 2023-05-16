package com.example.kursach.components;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class HibernateCacheHelper {

    private final EntityManager entityManager;

    public HibernateCacheHelper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void clearMetadataCache() {
        Session session = entityManager.unwrap(Session.class);
        session.getSessionFactory().getCache().evictAll();
    }
}
