package com.casestudy.casestudy.models.gallery;

import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_gallery")
public class Category_Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

}
