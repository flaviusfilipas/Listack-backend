package com.backend.listack.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class ShoppingListContributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShoppingList shoppingList;
    @ManyToOne
    private User user;
}
