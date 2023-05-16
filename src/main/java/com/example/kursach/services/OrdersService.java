package com.example.kursach.services;

import com.example.kursach.models.*;
import com.example.kursach.repositories.InstRepository;
import com.example.kursach.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        order.setOrderStatus("Новый");

        List<BucketDetailDTO> listOfDetails = bucketDTO.getBucketDetails();
        List<Long> instIdList = listOfDetails.stream().map(BucketDetailDTO::getIdInst).collect(Collectors.toList());
        List<Instrument> instListForOrder = instRepository.findByIdInstIn(instIdList);
        Set<Instrument> instSet = new HashSet<>(instListForOrder);
        order.setInstruments(instSet);
        ordersRepository.save(order);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<OrderDetail> listAllDetailedOrders() {
        List<Orders> orders = ordersRepository.findAll(); // Здесь ordersRepository - ваш репозиторий для работы с таблицей "orders"

        return orders.stream().map(this::mapToOrderDetail).collect(Collectors.toList());
    }

    private OrderDetail mapToOrderDetail(Orders order) {
        Long idOrder = order.getIdOrder();
        String userEmail = order.getUser().getUserEmail();
        String userPhone = order.getUser().getUserPhone();
        LocalDate orderCrDate = LocalDate.from(order.getOrderCrDate());
        LocalDate orderDelivDate = order.getOrderDelivDate();
        Double orderSum = order.getOrderPrice();
        String orderType = order.getOrderType();
        String status = order.getOrderStatus();

        List<String> orderInstList = getOrderInstrumentNames(order.getIdOrder());

        return OrderDetail.builder()
                .idOrder(idOrder)
                .userEmail(userEmail)
                .userPhone(userPhone)
                .orderCrDate(orderCrDate)
                .orderDelivDate(orderDelivDate)
                .orderSum(orderSum)
                .orderType(orderType)
                .orderInstList(orderInstList)
                .status(status)
                .build();
    }

    private List<String> getOrderInstrumentNames(Long orderId) {
        // Выполните дополнительный запрос для получения имен инструментов для данного orderId
        Query query = entityManager.createNativeQuery(
                "SELECT i.inst_name FROM instruments i JOIN orders_instruments oi ON i.id_inst = oi.instruments_id_inst WHERE oi.orders_id_order = :orderId"
        );
        query.setParameter("orderId", orderId);
        List<String> instrumentNames = query.getResultList();

        return instrumentNames;
    }

    public Orders findOrderById(Long orderId) {
        return ordersRepository.findByIdOrder(orderId);
    }

    public void updateOrder(Orders order) {
        ordersRepository.save(order);
    }
}

