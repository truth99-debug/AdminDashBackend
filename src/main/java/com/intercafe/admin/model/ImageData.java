package com.intercafe.admin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="images")
@Getter
@Setter
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "image_name")
    private String imageName;

    @Column(name= "url")
    private String url;

    @Column(name= "deleted")
    private int deleted;
}
