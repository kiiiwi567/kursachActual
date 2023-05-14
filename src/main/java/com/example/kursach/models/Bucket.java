package com.example.kursach.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buckets")
public class Bucket {
    /*private static final String SEQ_NAME ="bucket_seq";*/

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToMany
    @JoinTable(name = "buckets_instruments",
                joinColumns = @JoinColumn(name = "idBucket"),
                inverseJoinColumns = @JoinColumn(name = "idInst"))
    private List<Instrument> instruments;
}
