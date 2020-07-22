package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.repository.ContractOpportunityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ContractOpportunity}.
 */
@Service
@Transactional
public class ContractOpportunityService {

    private final Logger log = LoggerFactory.getLogger(ContractOpportunityService.class);

    private final ContractOpportunityRepository contractOpportunityRepository;

    public ContractOpportunityService(ContractOpportunityRepository contractOpportunityRepository) {
        this.contractOpportunityRepository = contractOpportunityRepository;
    }

    /**
     * Save a contractOpportunity.
     *
     * @param contractOpportunity the entity to save.
     * @return the persisted entity.
     */
    public ContractOpportunity save(ContractOpportunity contractOpportunity) {
        log.debug("Request to save ContractOpportunity : {}", contractOpportunity);
        return contractOpportunityRepository.save(contractOpportunity);
    }

    /**
     * Get all the contractOpportunities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ContractOpportunity> findAll(Pageable pageable) {
        log.debug("Request to get all ContractOpportunities");
        return contractOpportunityRepository.findAll(pageable);
    }


    /**
     * Get one contractOpportunity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ContractOpportunity> findOne(Long id) {
        log.debug("Request to get ContractOpportunity : {}", id);
        return contractOpportunityRepository.findById(id);
    }

    /**
     * Delete the contractOpportunity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ContractOpportunity : {}", id);
        contractOpportunityRepository.deleteById(id);
    }
}
