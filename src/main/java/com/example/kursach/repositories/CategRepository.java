package com.example.kursach.repositories;

import com.example.kursach.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CategRepository extends JpaRepository<Category, Long> {
}
