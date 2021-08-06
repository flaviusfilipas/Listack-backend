package com.backend.listack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ShoppingListContributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ShoppingList shoppingList;
    @ManyToOne
    private User user;
}
