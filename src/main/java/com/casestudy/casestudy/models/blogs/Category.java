package com.casestudy.casestudy.models.blogs;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "post_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


}
