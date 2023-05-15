package com.example.kursach.services;

import com.example.kursach.models.*;
import com.example.kursach.repositories.BucketRepository;
import com.example.kursach.repositories.InstRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService {
    private final BucketRepository bucketRepository;
    private final InstRepository instRepository;
    private final UserService userService;

    public BucketServiceImpl(BucketRepository bucketRepository, InstRepository instRepository, UserService userService) {
        this.bucketRepository = bucketRepository;
        this.instRepository = instRepository;
        this.userService = userService;
    }


    @Override
    @Transactional
    public Bucket createBucket(User user, List<Long> idInstList) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Instrument> instrumentList = getCollectRefInstrumentsByIds(idInstList);
        bucket.setInstruments(instrumentList);
        return bucketRepository.save(bucket);
    }

    private List<Instrument> getCollectRefInstrumentsByIds(List<Long> idInstList) {
        return idInstList.stream()
                .map(instRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addInstruments(Bucket bucket, List<Long> idInstList) {
        List<Instrument> instruments = bucket.getInstruments();
        List<Instrument> newInstList = instruments == null ? new ArrayList<>() : new ArrayList<>(instruments);
        newInstList.addAll(getCollectRefInstrumentsByIds(idInstList));
        bucket.setInstruments(newInstList);
        bucketRepository.save(bucket);
    }

    @Override
    public BucketDTO getBucketByUserEmail(String userEmail) {
        User user = userService.findByUserEmail(userEmail);
        if (user == null || user.getBucket() == null) {
            return new BucketDTO();
        }

        BucketDTO bucketDTO = new BucketDTO();
        Map<Long, BucketDetailDTO> mapByIdInst = new HashMap<>();

        List<Instrument> instruments = user.getBucket().getInstruments();
        for (Instrument instrument : instruments) {
            BucketDetailDTO detail = mapByIdInst.get(instrument.getIdInst());
            if (detail == null) {
                mapByIdInst.put(instrument.getIdInst(), new BucketDetailDTO(instrument));
            } else {
                detail.setInstQuantity(detail.getInstQuantity() + 1);
                detail.setSum(detail.getSum() + Double.valueOf(instrument.getInstPrice().toString()));
            }
        }

        bucketDTO.setBucketDetails(new ArrayList<>(mapByIdInst.values()));
        bucketDTO.aggregate();

        return bucketDTO;
    }
}
