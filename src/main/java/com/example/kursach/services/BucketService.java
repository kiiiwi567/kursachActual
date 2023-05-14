package com.example.kursach.services;

import com.example.kursach.models.BucketDTO;
import com.example.kursach.models.User;
import com.example.kursach.models.Bucket;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> idInstList);

    void addInstruments(Bucket bucket, List<Long> idInstList);

    BucketDTO getBucketByUser(String name);
}
