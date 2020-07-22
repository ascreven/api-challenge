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

import com.mycompany.myapp.domain.Naics;
import com.mycompany.myapp.domain.*; // for static metamodels
import com.mycompany.myapp.repository.NaicsRepository;
import com.mycompany.myapp.service.dto.NaicsCriteria;

/**
 * Service for executing complex queries for {@link Naics} entities in the database.
 * The main input is a {@link NaicsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Naics} or a {@link Page} of {@link Naics} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class NaicsQueryService extends QueryService<Naics> {

    private final Logger log = LoggerFactory.getLogger(NaicsQueryService.class);

    private final NaicsRepository naicsRepository;

    public NaicsQueryService(NaicsRepository naicsRepository) {
        this.naicsRepository = naicsRepository;
    }

    /**
     * Return a {@link List} of {@link Naics} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Naics> findByCriteria(NaicsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Naics> specification = createSpecification(criteria);
        return naicsRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Naics} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Naics> findByCriteria(NaicsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Naics> specification = createSpecification(criteria);
        return naicsRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(NaicsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Naics> specification = createSpecification(criteria);
        return naicsRepository.count(specification);
    }

    /**
     * Function to convert {@link NaicsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Naics> createSpecification(NaicsCriteria criteria) {
        Specification<Naics> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Naics_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), Naics_.code));
            }
            if (criteria.getTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitle(), Naics_.title));
            }
        }
        return specification;
    }
}
