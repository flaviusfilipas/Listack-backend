package com.backend.listack.repository;

import com.backend.listack.entity.ContributorInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorInvitationRepository extends JpaRepository<ContributorInvitation,Integer> {
}
