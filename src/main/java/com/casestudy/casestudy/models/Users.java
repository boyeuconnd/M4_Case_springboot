package com.casestudy.casestudy.models;



import lombok.Data;

import javax.persistence.*;
import java.security.Principal;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    private String nickName;

    private Float price;

    private Timestamp birthday;

    private String email;

    @Column(unique = true,nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "ranks_id")
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private String avatar;






}
