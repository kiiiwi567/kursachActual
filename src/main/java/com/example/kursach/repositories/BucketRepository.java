package com.example.kursach.repositories;

import com.example.kursach.models.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BucketRepository extends JpaRepository<Bucket, Long>{

}
