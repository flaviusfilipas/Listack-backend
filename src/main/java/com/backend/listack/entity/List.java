package com.backend.listack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Embedded
    private Location location;
}
