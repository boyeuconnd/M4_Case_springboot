package com.casestudy.casestudy.models.blogs;


import com.casestudy.casestudy.models.Users;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blogs")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private Timestamp date_create = new Timestamp(System.currentTimeMillis());

    @Column(columnDefinition = "Integer default 0")
    private Long likes;


    @ManyToOne
    private Users users;

    @ManyToOne
    private Category category;
}
