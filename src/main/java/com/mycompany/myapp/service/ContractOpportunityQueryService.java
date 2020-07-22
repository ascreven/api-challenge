package com.mycompany.myapp.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.domain.*; // for static metamodels
import com.mycompany.myapp.repository.ContractOpportunityRepository;
import com.mycompany.myapp.service.dto.ContractOpportunityCriteria;

/**
 * Service for executing complex queries for {@link ContractOpportunity} entities in the database.
 * The main input is a {@link ContractOpportunityCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ContractOpportunity} or a {@link Page} of {@link ContractOpportunity} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ContractOpportunityQueryService extends QueryService<ContractOpportunity> {

    private final Logger log = LoggerFactory.getLogger(ContractOpportunityQueryService.class);

    private final ContractOpportunityRepository contractOpportunityRepository;

    public ContractOpportunityQueryService(ContractOpportunityRepository contractOpportunityRepository) {
        this.contractOpportunityRepository = contractOpportunityRepository;
    }

    /**
     * Return a {@link List} of {@link ContractOpportunity} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ContractOpportunity> findByCriteria(ContractOpportunityCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ContractOpportunity> specification = createSpecification(criteria);
        return contractOpportunityRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link ContractOpportunity} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ContractOpportunity> findByCriteria(ContractOpportunityCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ContractOpportunity> specification = createSpecification(criteria);
        return contractOpportunityRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ContractOpportunityCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ContractOpportunity> specification = createSpecification(criteria);
        return contractOpportunityRepository.count(specification);
    }

    /**
     * Function to convert {@link ContractOpportunityCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ContractOpportunity> createSpecification(ContractOpportunityCriteria criteria) {
        Specification<ContractOpportunity> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ContractOpportunity_.id));
            }
            if (criteria.getContractId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContractId(), ContractOpportunity_.contractId));
            }
            if (criteria.getTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitle(), ContractOpportunity_.title));
            }
            if (criteria.getSol() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSol(), ContractOpportunity_.sol));
            }
            if (criteria.getAgency() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAgency(), ContractOpportunity_.agency));
            }
            if (criteria.getSubTier() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSubTier(), ContractOpportunity_.subTier));
            }
            if (criteria.getOffice() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOffice(), ContractOpportunity_.office));
            }
            if (criteria.getPosteddate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPosteddate(), ContractOpportunity_.posteddate));
            }
            if (criteria.getType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getType(), ContractOpportunity_.type));
            }
            if (criteria.getBasetype() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBasetype(), ContractOpportunity_.basetype));
            }
            if (criteria.getSetasidecode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSetasidecode(), ContractOpportunity_.setasidecode));
            }
            if (criteria.getSetaside() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSetaside(), ContractOpportunity_.setaside));
            }
            if (criteria.getResponsedeadline() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResponsedeadline(), ContractOpportunity_.responsedeadline));
            }
            if (criteria.getNaicscode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNaicscode(), ContractOpportunity_.naicscode));
            }
            if (criteria.getClassificationcode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getClassificationcode(), ContractOpportunity_.classificationcode));
            }
            if (criteria.getPopstate() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPopstate(), ContractOpportunity_.popstate));
            }
            if (criteria.getPopzip() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPopzip(), ContractOpportunity_.popzip));
            }
            if (criteria.getPopcountry() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPopcountry(), ContractOpportunity_.popcountry));
            }
            if (criteria.getActive() != null) {
                specification = specification.and(buildStringSpecification(criteria.getActive(), ContractOpportunity_.active));
            }
            if (criteria.getOrganizationtype() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOrganizationtype(), ContractOpportunity_.organizationtype));
            }
        }
        return specification;
    }
}
