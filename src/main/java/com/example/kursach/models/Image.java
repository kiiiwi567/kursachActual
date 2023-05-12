package com.example.kursach.models;

import jakarta.persistence.*;
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
    @Column//(name = "id")
    private Long imgId;
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
    @Column (name = "idInst")
    private Long idInst;
}
