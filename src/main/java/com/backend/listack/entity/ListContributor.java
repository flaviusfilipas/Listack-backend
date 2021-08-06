package com.backend.listack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ListContributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private List list;
    @ManyToOne
    private User user;
}
