package com.example.kursach.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "orders_instruments",
        indexes = {
                @Index(name = "idx_orders_instruments_orders_instruments", columnList = "orders_id_order, instruments_id_inst")
        })
public class OrdersInstruments {

    @ManyToOne
    @JoinColumn(name = "orders_id_order")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "instruments_id_inst")
    @Column(unique = false) // Здесь вы можете указать false, чтобы не создавать уникальный индекс
    private Instrument instruments;

    // остальной код с геттерами и сеттерами, конструкторами и т.д.
}
