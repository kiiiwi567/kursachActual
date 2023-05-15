package com.example.kursach.services;

import com.example.kursach.models.BucketDTO;
import com.example.kursach.models.User;
import com.example.kursach.models.Bucket;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> idInstList);

    void addOrRemoveInstruments(Bucket bucket, List<Long> idInstList, boolean add, Long idInstToRemove);

    BucketDTO getBucketByUserEmail(String userEmail);
}
