package com.backend.listack.entity;

import com.backend.listack.enums.InvitationStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ContributorInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Enumerated(EnumType.STRING)
    private InvitationStatus status;
    private Boolean sentEmail;
    @ManyToOne
    private ShoppingList shoppingList;
}
