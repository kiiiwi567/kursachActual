package com.example.kursach.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column
    private Long idCateg;
    @Column
    private String categName;
    @OneToMany//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "idCateg", referencedColumnName = "idCateg")
    @JsonIgnore
    private List<Instrument> instruments = new ArrayList<>();
}