package com.backend.listack.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean completed;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShoppingList list;
}
