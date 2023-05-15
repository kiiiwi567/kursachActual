package com.example.kursach.services;

import com.example.kursach.models.*;
import com.example.kursach.repositories.InstRepository;
import com.example.kursach.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class OrdersService {

    private final InstRepository instRepository;
    private final OrdersRepository ordersRepository;
    public void addOrder(BucketDTO bucketDTO, LocalDate orderDelivDate, String orderType, User user) {
        Orders order = new Orders();
        order.setUser(user);
        order.setOrderPrice(bucketDTO.getSum());
        order.setOrderType(orderType);
        order.setOrderDelivDate(orderDelivDate);
        order.setOrderCrDate(LocalDateTime.now());

        List<BucketDetailDTO> listOfDetails = bucketDTO.getBucketDetails();
        List<Long> instIdList = listOfDetails.stream().map(BucketDetailDTO::getIdInst).collect(Collectors.toList());
        List<Instrument> instListForOrder = instRepository.findByIdInstIn(instIdList);
        Set<Instrument> instSet = new HashSet<>(instListForOrder);
        order.setInstruments(instSet);
        ordersRepository.save(order);
    }
}
