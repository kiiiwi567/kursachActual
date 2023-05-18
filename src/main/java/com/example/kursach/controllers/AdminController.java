package com.example.kursach.controllers;

import com.example.kursach.models.OrderDetail;
import com.example.kursach.models.Orders;
import com.example.kursach.models.User;
import com.example.kursach.models.enums.Role;
import com.example.kursach.services.InstService;
import com.example.kursach.services.OrdersService;
import com.example.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    private final OrdersService ordersService;
    private final InstService instService;

    @GetMapping("/adminPage")
    public String admin(Model model, Principal principal){
        List<OrderDetail> orderDetails = ordersService.listAllDetailedOrders();
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("roles", Role.values());
        return "adminPage";
    }

    @PostMapping("/updateOrderStatus")
    public String updateOrderStatus(@RequestParam Long orderId, @RequestParam String status) {
        Orders order = ordersService.findOrderById(orderId);

        if (order != null) {
            if (status.equals("Новый")) {
                order.setOrderStatus("Активный");
            } else if (status.equals("Активный")) {
                order.setOrderStatus("Выполнен");
            } else if (status.equals("Выполнен")) {
                order.setOrderStatus("Новый");
            }

            ordersService.updateOrder(order);
        }

        return "redirect:/adminPage";
    }
    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id) {
        userService.banUser(id);
        return "redirect:/adminPage";
    }

    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model, Principal principal) {
        model.addAttribute("user", user);
        model.addAttribute("userPr", instService.getUserByPrincipal(principal));
        model.addAttribute("roles", Role.values());
        return "editUser";
    }

    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("idUser") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/adminPage";
    }
}
