package com.backend.listack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean canceled;
    @ManyToOne
    private ShoppingList shoppingList;
}
