package com.backend.listack.repository;

import com.backend.listack.entity.ContributorInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributorInvitationRepository extends JpaRepository<ContributorInvitation, Integer> {
    @Query("SELECT i from ContributorInvitation i " +
            "where i.status = 'PENDING' " +
            "AND i.shoppingList.id = :id")
    List<ContributorInvitation> findAllPendingInvitationsByListId(@Param("id") Integer id);
    ContributorInvitation findByEmailAndShoppingListId(String email, Integer shoppingListId);
}
