package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.repository.ContractOpportunityRepository;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.ContractOpportunity}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ContractOpportunityResource {

    private final Logger log = LoggerFactory.getLogger(ContractOpportunityResource.class);

    private static final String ENTITY_NAME = "contractOpportunity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ContractOpportunityRepository contractOpportunityRepository;

    public ContractOpportunityResource(ContractOpportunityRepository contractOpportunityRepository) {
        this.contractOpportunityRepository = contractOpportunityRepository;
    }

    /**
     * {@code POST  /contract-opportunities} : Create a new contractOpportunity.
     *
     * @param contractOpportunity the contractOpportunity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new contractOpportunity, or with status {@code 400 (Bad Request)} if the contractOpportunity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/contract-opportunities")
    public ResponseEntity<ContractOpportunity> createContractOpportunity(@Valid @RequestBody ContractOpportunity contractOpportunity) throws URISyntaxException {
        log.debug("REST request to save ContractOpportunity : {}", contractOpportunity);
        if (contractOpportunity.getId() != null) {
            throw new BadRequestAlertException("A new contractOpportunity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ContractOpportunity result = contractOpportunityRepository.save(contractOpportunity);
        return ResponseEntity.created(new URI("/api/contract-opportunities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /contract-opportunities} : Updates an existing contractOpportunity.
     *
     * @param contractOpportunity the contractOpportunity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated contractOpportunity,
     * or with status {@code 400 (Bad Request)} if the contractOpportunity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the contractOpportunity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/contract-opportunities")
    public ResponseEntity<ContractOpportunity> updateContractOpportunity(@Valid @RequestBody ContractOpportunity contractOpportunity) throws URISyntaxException {
        log.debug("REST request to update ContractOpportunity : {}", contractOpportunity);
        if (contractOpportunity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ContractOpportunity result = contractOpportunityRepository.save(contractOpportunity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, contractOpportunity.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /contract-opportunities} : get all the contractOpportunities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of contractOpportunities in body.
     */
    @GetMapping("/contract-opportunities")
    public List<ContractOpportunity> getAllContractOpportunities() {
        log.debug("REST request to get all ContractOpportunities");
        return contractOpportunityRepository.findAll();
    }

    /**
     * {@code GET  /contract-opportunities/:id} : get the "id" contractOpportunity.
     *
     * @param id the id of the contractOpportunity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the contractOpportunity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/contract-opportunities/{id}")
    public ResponseEntity<ContractOpportunity> getContractOpportunity(@PathVariable Long id) {
        log.debug("REST request to get ContractOpportunity : {}", id);
        Optional<ContractOpportunity> contractOpportunity = contractOpportunityRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(contractOpportunity);
    }

    /**
     * {@code DELETE  /contract-opportunities/:id} : delete the "id" contractOpportunity.
     *
     * @param id the id of the contractOpportunity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/contract-opportunities/{id}")
    public ResponseEntity<Void> deleteContractOpportunity(@PathVariable Long id) {
        log.debug("REST request to delete ContractOpportunity : {}", id);
        contractOpportunityRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
