package com.backend.listack.repository;

import com.backend.listack.entity.ShoppingListContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListContributorRepository extends JpaRepository<ShoppingListContributor, Integer> {

    List<ShoppingListContributor> findAllByShoppingListId(Integer listId);
}
