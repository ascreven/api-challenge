package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.OpportunityOpportunity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OpportunityOpportunity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpportunityOpportunityRepository extends JpaRepository<OpportunityOpportunity, Long> {
}
