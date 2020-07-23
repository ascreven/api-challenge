package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.OpportunitiesApp;
import com.mycompany.myapp.domain.Naics;
import com.mycompany.myapp.repository.NaicsRepository;
import com.mycompany.myapp.service.NaicsService;
import com.mycompany.myapp.service.dto.NaicsCriteria;
import com.mycompany.myapp.service.NaicsQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link NaicsResource} REST controller.
 */
@SpringBootTest(classes = OpportunitiesApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NaicsResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private NaicsRepository naicsRepository;

    @Autowired
    private NaicsService naicsService;

    @Autowired
    private NaicsQueryService naicsQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNaicsMockMvc;

    private Naics naics;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Naics createEntity(EntityManager em) {
        Naics naics = new Naics()
            .code(DEFAULT_CODE)
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION);
        return naics;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Naics createUpdatedEntity(EntityManager em) {
        Naics naics = new Naics()
            .code(UPDATED_CODE)
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION);
        return naics;
    }

    @BeforeEach
    public void initTest() {
        naics = createEntity(em);
    }

    @Test
    @Transactional
    public void getAllNaics() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList
        restNaicsMockMvc.perform(get("/api/naics?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(naics.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())));
    }
    
    @Test
    @Transactional
    public void getNaics() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get the naics
        restNaicsMockMvc.perform(get("/api/naics/{id}", naics.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(naics.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()));
    }


    @Test
    @Transactional
    public void getNaicsByIdFiltering() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        Long id = naics.getId();

        defaultNaicsShouldBeFound("id.equals=" + id);
        defaultNaicsShouldNotBeFound("id.notEquals=" + id);

        defaultNaicsShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultNaicsShouldNotBeFound("id.greaterThan=" + id);

        defaultNaicsShouldBeFound("id.lessThanOrEqual=" + id);
        defaultNaicsShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllNaicsByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code equals to DEFAULT_CODE
        defaultNaicsShouldBeFound("code.equals=" + DEFAULT_CODE);

        // Get all the naicsList where code equals to UPDATED_CODE
        defaultNaicsShouldNotBeFound("code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllNaicsByCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code not equals to DEFAULT_CODE
        defaultNaicsShouldNotBeFound("code.notEquals=" + DEFAULT_CODE);

        // Get all the naicsList where code not equals to UPDATED_CODE
        defaultNaicsShouldBeFound("code.notEquals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllNaicsByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code in DEFAULT_CODE or UPDATED_CODE
        defaultNaicsShouldBeFound("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE);

        // Get all the naicsList where code equals to UPDATED_CODE
        defaultNaicsShouldNotBeFound("code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllNaicsByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code is not null
        defaultNaicsShouldBeFound("code.specified=true");

        // Get all the naicsList where code is null
        defaultNaicsShouldNotBeFound("code.specified=false");
    }
                @Test
    @Transactional
    public void getAllNaicsByCodeContainsSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code contains DEFAULT_CODE
        defaultNaicsShouldBeFound("code.contains=" + DEFAULT_CODE);

        // Get all the naicsList where code contains UPDATED_CODE
        defaultNaicsShouldNotBeFound("code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllNaicsByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where code does not contain DEFAULT_CODE
        defaultNaicsShouldNotBeFound("code.doesNotContain=" + DEFAULT_CODE);

        // Get all the naicsList where code does not contain UPDATED_CODE
        defaultNaicsShouldBeFound("code.doesNotContain=" + UPDATED_CODE);
    }


    @Test
    @Transactional
    public void getAllNaicsByTitleIsEqualToSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title equals to DEFAULT_TITLE
        defaultNaicsShouldBeFound("title.equals=" + DEFAULT_TITLE);

        // Get all the naicsList where title equals to UPDATED_TITLE
        defaultNaicsShouldNotBeFound("title.equals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllNaicsByTitleIsNotEqualToSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title not equals to DEFAULT_TITLE
        defaultNaicsShouldNotBeFound("title.notEquals=" + DEFAULT_TITLE);

        // Get all the naicsList where title not equals to UPDATED_TITLE
        defaultNaicsShouldBeFound("title.notEquals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllNaicsByTitleIsInShouldWork() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title in DEFAULT_TITLE or UPDATED_TITLE
        defaultNaicsShouldBeFound("title.in=" + DEFAULT_TITLE + "," + UPDATED_TITLE);

        // Get all the naicsList where title equals to UPDATED_TITLE
        defaultNaicsShouldNotBeFound("title.in=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllNaicsByTitleIsNullOrNotNull() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title is not null
        defaultNaicsShouldBeFound("title.specified=true");

        // Get all the naicsList where title is null
        defaultNaicsShouldNotBeFound("title.specified=false");
    }
                @Test
    @Transactional
    public void getAllNaicsByTitleContainsSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title contains DEFAULT_TITLE
        defaultNaicsShouldBeFound("title.contains=" + DEFAULT_TITLE);

        // Get all the naicsList where title contains UPDATED_TITLE
        defaultNaicsShouldNotBeFound("title.contains=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllNaicsByTitleNotContainsSomething() throws Exception {
        // Initialize the database
        naicsRepository.saveAndFlush(naics);

        // Get all the naicsList where title does not contain DEFAULT_TITLE
        defaultNaicsShouldNotBeFound("title.doesNotContain=" + DEFAULT_TITLE);

        // Get all the naicsList where title does not contain UPDATED_TITLE
        defaultNaicsShouldBeFound("title.doesNotContain=" + UPDATED_TITLE);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultNaicsShouldBeFound(String filter) throws Exception {
        restNaicsMockMvc.perform(get("/api/naics?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(naics.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())));

        // Check, that the count call also returns 1
        restNaicsMockMvc.perform(get("/api/naics/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultNaicsShouldNotBeFound(String filter) throws Exception {
        restNaicsMockMvc.perform(get("/api/naics?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restNaicsMockMvc.perform(get("/api/naics/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingNaics() throws Exception {
        // Get the naics
        restNaicsMockMvc.perform(get("/api/naics/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }
}
