package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Naics;
import com.mycompany.myapp.service.NaicsService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.NaicsCriteria;
import com.mycompany.myapp.service.NaicsQueryService;

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
 * REST controller for managing {@link com.mycompany.myapp.domain.Naics}.
 */
@RestController
@RequestMapping("/api")
public class NaicsResource {

    private final Logger log = LoggerFactory.getLogger(NaicsResource.class);

    private final NaicsService naicsService;

    private final NaicsQueryService naicsQueryService;

    public NaicsResource(NaicsService naicsService, NaicsQueryService naicsQueryService) {
        this.naicsService = naicsService;
        this.naicsQueryService = naicsQueryService;
    }

    /**
     * {@code GET  /naics} : get all the naics.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of naics in body.
     */
    @GetMapping("/naics")
    public ResponseEntity<List<Naics>> getAllNaics(NaicsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Naics by criteria: {}", criteria);
        Page<Naics> page = naicsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /naics/count} : count all the naics.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/naics/count")
    public ResponseEntity<Long> countNaics(NaicsCriteria criteria) {
        log.debug("REST request to count Naics by criteria: {}", criteria);
        return ResponseEntity.ok().body(naicsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /naics/:id} : get the "id" naics.
     *
     * @param id the id of the naics to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the naics, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/naics/{id}")
    public ResponseEntity<Naics> getNaics(@PathVariable Long id) {
        log.debug("REST request to get Naics : {}", id);
        Optional<Naics> naics = naicsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(naics);
    }
}
