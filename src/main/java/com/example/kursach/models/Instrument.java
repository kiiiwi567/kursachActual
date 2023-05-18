package com.example.kursach.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "instruments")
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idInst;

    @Column
    private String instName;

    @Column(name = "idCateg")
    private Long idCateg;

    @Column
    private Double instPrice;

    @Column
    private Integer instQuantity;

    @Column
    private String instDescription;

  /*  @Column
    private String author;*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/*, mappedBy = "instrument"*/)
    @JoinColumn (name = "idInst", referencedColumnName = "idInst")
    @JsonIgnore
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;

    @ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "idUser")
    @JsonIgnore
    private User user;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image) {
        image.setInstrument(this);
        images.add(image);
    }
}
