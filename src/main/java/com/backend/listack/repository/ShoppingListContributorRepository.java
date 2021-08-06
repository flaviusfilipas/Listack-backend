package com.backend.listack.repository;

import com.backend.listack.entity.ShoppingListContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ShoppingListContributorRepository extends JpaRepository<ShoppingListContributor, Integer> {
}
