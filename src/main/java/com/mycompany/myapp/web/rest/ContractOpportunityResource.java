package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.service.ContractOpportunityService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.ContractOpportunityCriteria;
import com.mycompany.myapp.service.dto.IndustryOppCountDTO;
import com.mycompany.myapp.service.ContractOpportunityQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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

    private final ContractOpportunityQueryService contractOpportunityQueryService;

    public ContractOpportunityResource(ContractOpportunityService contractOpportunityService, ContractOpportunityQueryService contractOpportunityQueryService) {
        this.contractOpportunityService = contractOpportunityService;
        this.contractOpportunityQueryService = contractOpportunityQueryService;
    }

    /**
     * {@code GET  /contract-opportunities} : get all the contractOpportunities.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of contractOpportunities in body.
     */
    @GetMapping("/contract-opportunities")
    public ResponseEntity<List<ContractOpportunity>> getAllContractOpportunities(ContractOpportunityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ContractOpportunities by criteria: {}", criteria);
        Page<ContractOpportunity> page = contractOpportunityQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /contract-opportunities/count} : count all the contractOpportunities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/contract-opportunities/count")
    public ResponseEntity<Long> countContractOpportunities(ContractOpportunityCriteria criteria) {
        log.debug("REST request to count ContractOpportunities by criteria: {}", criteria);
        return ResponseEntity.ok().body(contractOpportunityQueryService.countByCriteria(criteria));
    }

    /*
     * {@code GET  /contract-opportunities/count} : count all the contractOpportunities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/contract-opportunities/industry_opp_counts")
    public ResponseEntity<IndustryOppCountDTO> countIndustryOpportunities() {
        log.debug("REST request to count ContractOpportunities by industry");
        IndustryOppCountDTO count = new IndustryOppCountDTO();
        count.setOppCount(new Long(5342));
        count.setNaicsCode("840239");
        count.setTitle("My Fantastic Title");
        return ResponseEntity.ok().body(count);
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
        Optional<ContractOpportunity> contractOpportunity = contractOpportunityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contractOpportunity);
    }
}
