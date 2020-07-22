package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Naics;
import com.mycompany.myapp.repository.NaicsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Naics}.
 */
@Service
@Transactional
public class NaicsService {

    private final Logger log = LoggerFactory.getLogger(NaicsService.class);

    private final NaicsRepository naicsRepository;

    public NaicsService(NaicsRepository naicsRepository) {
        this.naicsRepository = naicsRepository;
    }

    /**
     * Save a naics.
     *
     * @param naics the entity to save.
     * @return the persisted entity.
     */
    public Naics save(Naics naics) {
        log.debug("Request to save Naics : {}", naics);
        return naicsRepository.save(naics);
    }

    /**
     * Get all the naics.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Naics> findAll(Pageable pageable) {
        log.debug("Request to get all Naics");
        return naicsRepository.findAll(pageable);
    }


    /**
     * Get one naics by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Naics> findOne(Long id) {
        log.debug("Request to get Naics : {}", id);
        return naicsRepository.findById(id);
    }

    /**
     * Delete the naics by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Naics : {}", id);
        naicsRepository.deleteById(id);
    }
}
