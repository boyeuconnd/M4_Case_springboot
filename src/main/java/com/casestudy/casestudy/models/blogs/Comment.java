package com.casestudy.casestudy.models.blogs;


import com.casestudy.casestudy.models.Users;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Post post;

}
