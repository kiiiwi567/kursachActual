package com.example.kursach.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDetailDTO {
    private String title;
    private Long idInst;
    private Double instPrice;
    private Integer instQuantity;
    private Double sum;

    public BucketDetailDTO(Instrument instrument) {
        this.title = instrument.getInstName();
        this.idInst = instrument.getIdInst();
        this.instPrice = instrument.getInstPrice();
        this.instQuantity = 1;
        this.sum = Double.valueOf(instrument.getInstPrice().toString());
    }
}
