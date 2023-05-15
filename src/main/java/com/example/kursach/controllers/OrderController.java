package com.example.kursach.controllers;

import com.example.kursach.models.Bucket;
import com.example.kursach.models.BucketDTO;
import com.example.kursach.models.BucketDetailDTO;
import com.example.kursach.models.User;
import com.example.kursach.services.BucketService;
import com.example.kursach.services.InstService;
import com.example.kursach.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final BucketService bucketService;
    private final InstService instService;
    private final OrdersService ordersService;

    @GetMapping("/order")
    public String orderingInProgress(Principal principal, Model model) {
        BucketDTO bucketDTO = bucketService.getBucketByUserEmail(instService.getUserByPrincipal(principal).getUserEmail());
        model.addAttribute("bucket", bucketDTO);
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "orderingPage";
    }

    @PostMapping("/order/complete")
    public String orderComplete(Principal principal, Model model,
                                @RequestParam ("orderDelivDate") String orderDelivDate,
                                @RequestParam ("orderType") String orderType){

        LocalDate delivDate = LocalDate.parse(orderDelivDate);

        User user = instService.getUserByPrincipal(principal);
        BucketDTO bucketDTO = bucketService.getBucketByUserEmail(user.getUserEmail());
        model.addAttribute("user", user);
        ordersService.addOrder(bucketDTO, delivDate, orderType, user);
        return "orderCompletePage";
    }
}
