package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ContractOpportunityService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.ContractOpportunityDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
public class ContractOpportunityResource {

    private final Logger log = LoggerFactory.getLogger(ContractOpportunityResource.class);

    private final ContractOpportunityService contractOpportunityService;

    public ContractOpportunityResource(ContractOpportunityService contractOpportunityService) {
        this.contractOpportunityService = contractOpportunityService;
    }

    /**
     * {@code GET  /contract-opportunities} : get all the contractOpportunities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of contractOpportunities in body.
     */
    @GetMapping("/contract-opportunities")
    public List<ContractOpportunityDTO> getAllContractOpportunities() {
        log.debug("REST request to get all ContractOpportunities");
        return contractOpportunityService.findAll();
    }

    /**
     * {@code GET  /contract-opportunities/:id} : get the "id" contractOpportunity.
     *
     * @param id the id of the contractOpportunityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the contractOpportunityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/contract-opportunities/{id}")
    public ResponseEntity<ContractOpportunityDTO> getContractOpportunity(@PathVariable Long id) {
        log.debug("REST request to get ContractOpportunity : {}", id);
        Optional<ContractOpportunityDTO> contractOpportunityDTO = contractOpportunityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contractOpportunityDTO);
    }
}
