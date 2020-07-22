package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.OpportunityOpportunity;
import com.mycompany.myapp.repository.OpportunityOpportunityRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.OpportunityOpportunity}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class OpportunityOpportunityResource {

    private final Logger log = LoggerFactory.getLogger(OpportunityOpportunityResource.class);

    private static final String ENTITY_NAME = "opportunityOpportunity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OpportunityOpportunityRepository opportunityOpportunityRepository;

    public OpportunityOpportunityResource(OpportunityOpportunityRepository opportunityOpportunityRepository) {
        this.opportunityOpportunityRepository = opportunityOpportunityRepository;
    }

    /**
     * {@code POST  /opportunity-opportunities} : Create a new opportunityOpportunity.
     *
     * @param opportunityOpportunity the opportunityOpportunity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new opportunityOpportunity, or with status {@code 400 (Bad Request)} if the opportunityOpportunity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/opportunity-opportunities")
    public ResponseEntity<OpportunityOpportunity> createOpportunityOpportunity(@Valid @RequestBody OpportunityOpportunity opportunityOpportunity) throws URISyntaxException {
        log.debug("REST request to save OpportunityOpportunity : {}", opportunityOpportunity);
        if (opportunityOpportunity.getId() != null) {
            throw new BadRequestAlertException("A new opportunityOpportunity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpportunityOpportunity result = opportunityOpportunityRepository.save(opportunityOpportunity);
        return ResponseEntity.created(new URI("/api/opportunity-opportunities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /opportunity-opportunities} : Updates an existing opportunityOpportunity.
     *
     * @param opportunityOpportunity the opportunityOpportunity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated opportunityOpportunity,
     * or with status {@code 400 (Bad Request)} if the opportunityOpportunity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the opportunityOpportunity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/opportunity-opportunities")
    public ResponseEntity<OpportunityOpportunity> updateOpportunityOpportunity(@Valid @RequestBody OpportunityOpportunity opportunityOpportunity) throws URISyntaxException {
        log.debug("REST request to update OpportunityOpportunity : {}", opportunityOpportunity);
        if (opportunityOpportunity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OpportunityOpportunity result = opportunityOpportunityRepository.save(opportunityOpportunity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, opportunityOpportunity.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /opportunity-opportunities} : get all the opportunityOpportunities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of opportunityOpportunities in body.
     */
    @GetMapping("/opportunity-opportunities")
    public List<OpportunityOpportunity> getAllOpportunityOpportunities() {
        log.debug("REST request to get all OpportunityOpportunities");
        return opportunityOpportunityRepository.findAll();
    }

    /**
     * {@code GET  /opportunity-opportunities/:id} : get the "id" opportunityOpportunity.
     *
     * @param id the id of the opportunityOpportunity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the opportunityOpportunity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/opportunity-opportunities/{id}")
    public ResponseEntity<OpportunityOpportunity> getOpportunityOpportunity(@PathVariable Long id) {
        log.debug("REST request to get OpportunityOpportunity : {}", id);
        Optional<OpportunityOpportunity> opportunityOpportunity = opportunityOpportunityRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(opportunityOpportunity);
    }

    /**
     * {@code DELETE  /opportunity-opportunities/:id} : delete the "id" opportunityOpportunity.
     *
     * @param id the id of the opportunityOpportunity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/opportunity-opportunities/{id}")
    public ResponseEntity<Void> deleteOpportunityOpportunity(@PathVariable Long id) {
        log.debug("REST request to delete OpportunityOpportunity : {}", id);
        opportunityOpportunityRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
