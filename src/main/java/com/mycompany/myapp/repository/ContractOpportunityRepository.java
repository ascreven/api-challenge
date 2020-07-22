package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ContractOpportunity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ContractOpportunity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContractOpportunityRepository extends JpaRepository<ContractOpportunity, Long> {
}
