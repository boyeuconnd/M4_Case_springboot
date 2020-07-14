package com.casestudy.casestudy.models.gallery;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "galleries")
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String avatar;

    @ManyToOne
    private Category_Gallery categoryGallery;


}
