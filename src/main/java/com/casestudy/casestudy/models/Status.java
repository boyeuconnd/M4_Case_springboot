package com.casestudy.casestudy.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String statusName;

    public Status() {
    }


}
