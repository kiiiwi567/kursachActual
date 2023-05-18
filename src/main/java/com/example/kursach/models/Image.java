package com.example.kursach.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idImg")
    private Long idImg;
    @Column//(name = "name")
    private String imgName;
    @Column//(name = "originalFileName")
    private String originalFileName;
    @Column//(name = "size")
    private Long imgSize;
    @Column//(name = "contentType")
    private String imgContentType;
    @Column//(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn (name = "idInst")
    @JsonIgnore
    private Instrument instrument;
    /*@Column (name = "idInst")
    private Long idInst;*/
}
