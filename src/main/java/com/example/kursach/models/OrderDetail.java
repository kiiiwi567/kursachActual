package com.example.kursach.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    private Long idOrder;
    private String userEmail;
    private String userPhone;
    private LocalDate orderCrDate;
    private LocalDate orderDelivDate;
    private Double orderSum;
    private String orderType;
    private List<String> orderInstList;
    private String status;
}
