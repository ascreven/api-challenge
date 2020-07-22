package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.repository.ContractOpportunityRepository;
import com.mycompany.myapp.service.dto.ContractOpportunityDTO;
import com.mycompany.myapp.service.mapper.ContractOpportunityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ContractOpportunity}.
 */
@Service
@Transactional
public class ContractOpportunityService {

    private final Logger log = LoggerFactory.getLogger(ContractOpportunityService.class);

    private final ContractOpportunityRepository contractOpportunityRepository;

    private final ContractOpportunityMapper contractOpportunityMapper;

    public ContractOpportunityService(ContractOpportunityRepository contractOpportunityRepository, ContractOpportunityMapper contractOpportunityMapper) {
        this.contractOpportunityRepository = contractOpportunityRepository;
        this.contractOpportunityMapper = contractOpportunityMapper;
    }

    /**
     * Save a contractOpportunity.
     *
     * @param contractOpportunityDTO the entity to save.
     * @return the persisted entity.
     */
    public ContractOpportunityDTO save(ContractOpportunityDTO contractOpportunityDTO) {
        log.debug("Request to save ContractOpportunity : {}", contractOpportunityDTO);
        ContractOpportunity contractOpportunity = contractOpportunityMapper.toEntity(contractOpportunityDTO);
        contractOpportunity = contractOpportunityRepository.save(contractOpportunity);
        return contractOpportunityMapper.toDto(contractOpportunity);
    }

    /**
     * Get all the contractOpportunities.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ContractOpportunityDTO> findAll() {
        log.debug("Request to get all ContractOpportunities");
        return contractOpportunityRepository.findAll().stream()
            .map(contractOpportunityMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one contractOpportunity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ContractOpportunityDTO> findOne(Long id) {
        log.debug("Request to get ContractOpportunity : {}", id);
        return contractOpportunityRepository.findById(id)
            .map(contractOpportunityMapper::toDto);
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
