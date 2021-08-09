package com.backend.listack.repository;

import com.backend.listack.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
    @Query("SELECT sl from ShoppingList sl " +
            "INNER JOIN ShoppingListContributor slc on sl.id = slc.shoppingList.id " +
            "INNER JOIN User u on u.id = slc.user.id " +
            "where u.id = :id")
    List<ShoppingList> findShoppingListByUserId(@Param("id") String id);
}
