package com.example.kursach.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @Column(name = "idOrder")
    private Long idOrder;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "idUser")
    private User user;

    @Column
    private LocalDateTime orderCrDate;

    @Column
    private LocalDate orderDelivDate;

    @Column
    private Double orderPrice;

    @Column
    private String orderType;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Instrument> instruments=new HashSet<>();
}
