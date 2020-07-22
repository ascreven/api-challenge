package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.OpportunitiesApp;
import com.mycompany.myapp.domain.ContractOpportunity;
import com.mycompany.myapp.repository.ContractOpportunityRepository;
import com.mycompany.myapp.service.ContractOpportunityService;
import com.mycompany.myapp.service.dto.ContractOpportunityCriteria;
import com.mycompany.myapp.service.ContractOpportunityQueryService;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ContractOpportunityResource} REST controller.
 */
@SpringBootTest(classes = OpportunitiesApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class ContractOpportunityResourceIT {

    private static final String DEFAULT_CONTRACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_SOL = "AAAAAAAAAA";
    private static final String UPDATED_SOL = "BBBBBBBBBB";

    private static final String DEFAULT_AGENCY = "AAAAAAAAAA";
    private static final String UPDATED_AGENCY = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TIER = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TIER = "BBBBBBBBBB";

    private static final String DEFAULT_OFFICE = "AAAAAAAAAA";
    private static final String UPDATED_OFFICE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_POSTEDDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_POSTEDDATE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_POSTEDDATE = LocalDate.ofEpochDay(-1L);

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BASETYPE = "AAAAAAAAAA";
    private static final String UPDATED_BASETYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SETASIDECODE = "AAAAAAAAAA";
    private static final String UPDATED_SETASIDECODE = "BBBBBBBBBB";

    private static final String DEFAULT_SETASIDE = "AAAAAAAAAA";
    private static final String UPDATED_SETASIDE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_RESPONSEDEADLINE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESPONSEDEADLINE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_RESPONSEDEADLINE = LocalDate.ofEpochDay(-1L);

    private static final String DEFAULT_NAICSCODE = "AAAAAAAAAA";
    private static final String UPDATED_NAICSCODE = "BBBBBBBBBB";

    private static final String DEFAULT_CLASSIFICATIONCODE = "AAAAAAAAAA";
    private static final String UPDATED_CLASSIFICATIONCODE = "BBBBBBBBBB";

    private static final String DEFAULT_POPSTATE = "AAAAAAAAAA";
    private static final String UPDATED_POPSTATE = "BBBBBBBBBB";

    private static final String DEFAULT_POPZIP = "AAAAAAAAAA";
    private static final String UPDATED_POPZIP = "BBBBBBBBBB";

    private static final String DEFAULT_POPCOUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_POPCOUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGANIZATIONTYPE = "AAAAAAAAAA";
    private static final String UPDATED_ORGANIZATIONTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private ContractOpportunityRepository contractOpportunityRepository;

    @Autowired
    private ContractOpportunityService contractOpportunityService;

    @Autowired
    private ContractOpportunityQueryService contractOpportunityQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restContractOpportunityMockMvc;

    private ContractOpportunity contractOpportunity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ContractOpportunity createEntity(EntityManager em) {
        ContractOpportunity contractOpportunity = new ContractOpportunity()
            .contractId(DEFAULT_CONTRACT_ID)
            .title(DEFAULT_TITLE)
            .sol(DEFAULT_SOL)
            .agency(DEFAULT_AGENCY)
            .subTier(DEFAULT_SUB_TIER)
            .office(DEFAULT_OFFICE)
            .posteddate(DEFAULT_POSTEDDATE)
            .type(DEFAULT_TYPE)
            .basetype(DEFAULT_BASETYPE)
            .setasidecode(DEFAULT_SETASIDECODE)
            .setaside(DEFAULT_SETASIDE)
            .responsedeadline(DEFAULT_RESPONSEDEADLINE)
            .naicscode(DEFAULT_NAICSCODE)
            .classificationcode(DEFAULT_CLASSIFICATIONCODE)
            .popstate(DEFAULT_POPSTATE)
            .popzip(DEFAULT_POPZIP)
            .popcountry(DEFAULT_POPCOUNTRY)
            .active(DEFAULT_ACTIVE)
            .organizationtype(DEFAULT_ORGANIZATIONTYPE)
            .description(DEFAULT_DESCRIPTION);
        return contractOpportunity;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ContractOpportunity createUpdatedEntity(EntityManager em) {
        ContractOpportunity contractOpportunity = new ContractOpportunity()
            .contractId(UPDATED_CONTRACT_ID)
            .title(UPDATED_TITLE)
            .sol(UPDATED_SOL)
            .agency(UPDATED_AGENCY)
            .subTier(UPDATED_SUB_TIER)
            .office(UPDATED_OFFICE)
            .posteddate(UPDATED_POSTEDDATE)
            .type(UPDATED_TYPE)
            .basetype(UPDATED_BASETYPE)
            .setasidecode(UPDATED_SETASIDECODE)
            .setaside(UPDATED_SETASIDE)
            .responsedeadline(UPDATED_RESPONSEDEADLINE)
            .naicscode(UPDATED_NAICSCODE)
            .classificationcode(UPDATED_CLASSIFICATIONCODE)
            .popstate(UPDATED_POPSTATE)
            .popzip(UPDATED_POPZIP)
            .popcountry(UPDATED_POPCOUNTRY)
            .active(UPDATED_ACTIVE)
            .organizationtype(UPDATED_ORGANIZATIONTYPE)
            .description(UPDATED_DESCRIPTION);
        return contractOpportunity;
    }

    @BeforeEach
    public void initTest() {
        contractOpportunity = createEntity(em);
    }

    @Test
    @Transactional
    public void getAllContractOpportunities() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(contractOpportunity.getId().intValue())))
            .andExpect(jsonPath("$.[*].contractId").value(hasItem(DEFAULT_CONTRACT_ID)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].sol").value(hasItem(DEFAULT_SOL)))
            .andExpect(jsonPath("$.[*].agency").value(hasItem(DEFAULT_AGENCY)))
            .andExpect(jsonPath("$.[*].subTier").value(hasItem(DEFAULT_SUB_TIER)))
            .andExpect(jsonPath("$.[*].office").value(hasItem(DEFAULT_OFFICE)))
            .andExpect(jsonPath("$.[*].posteddate").value(hasItem(DEFAULT_POSTEDDATE.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].basetype").value(hasItem(DEFAULT_BASETYPE)))
            .andExpect(jsonPath("$.[*].setasidecode").value(hasItem(DEFAULT_SETASIDECODE)))
            .andExpect(jsonPath("$.[*].setaside").value(hasItem(DEFAULT_SETASIDE)))
            .andExpect(jsonPath("$.[*].responsedeadline").value(hasItem(DEFAULT_RESPONSEDEADLINE.toString())))
            .andExpect(jsonPath("$.[*].naicscode").value(hasItem(DEFAULT_NAICSCODE)))
            .andExpect(jsonPath("$.[*].classificationcode").value(hasItem(DEFAULT_CLASSIFICATIONCODE)))
            .andExpect(jsonPath("$.[*].popstate").value(hasItem(DEFAULT_POPSTATE)))
            .andExpect(jsonPath("$.[*].popzip").value(hasItem(DEFAULT_POPZIP)))
            .andExpect(jsonPath("$.[*].popcountry").value(hasItem(DEFAULT_POPCOUNTRY)))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE)))
            .andExpect(jsonPath("$.[*].organizationtype").value(hasItem(DEFAULT_ORGANIZATIONTYPE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())));
    }
    
    @Test
    @Transactional
    public void getContractOpportunity() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get the contractOpportunity
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities/{id}", contractOpportunity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(contractOpportunity.getId().intValue()))
            .andExpect(jsonPath("$.contractId").value(DEFAULT_CONTRACT_ID))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.sol").value(DEFAULT_SOL))
            .andExpect(jsonPath("$.agency").value(DEFAULT_AGENCY))
            .andExpect(jsonPath("$.subTier").value(DEFAULT_SUB_TIER))
            .andExpect(jsonPath("$.office").value(DEFAULT_OFFICE))
            .andExpect(jsonPath("$.posteddate").value(DEFAULT_POSTEDDATE.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.basetype").value(DEFAULT_BASETYPE))
            .andExpect(jsonPath("$.setasidecode").value(DEFAULT_SETASIDECODE))
            .andExpect(jsonPath("$.setaside").value(DEFAULT_SETASIDE))
            .andExpect(jsonPath("$.responsedeadline").value(DEFAULT_RESPONSEDEADLINE.toString()))
            .andExpect(jsonPath("$.naicscode").value(DEFAULT_NAICSCODE))
            .andExpect(jsonPath("$.classificationcode").value(DEFAULT_CLASSIFICATIONCODE))
            .andExpect(jsonPath("$.popstate").value(DEFAULT_POPSTATE))
            .andExpect(jsonPath("$.popzip").value(DEFAULT_POPZIP))
            .andExpect(jsonPath("$.popcountry").value(DEFAULT_POPCOUNTRY))
            .andExpect(jsonPath("$.active").value(DEFAULT_ACTIVE))
            .andExpect(jsonPath("$.organizationtype").value(DEFAULT_ORGANIZATIONTYPE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()));
    }


    @Test
    @Transactional
    public void getContractOpportunitiesByIdFiltering() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        Long id = contractOpportunity.getId();

        defaultContractOpportunityShouldBeFound("id.equals=" + id);
        defaultContractOpportunityShouldNotBeFound("id.notEquals=" + id);

        defaultContractOpportunityShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultContractOpportunityShouldNotBeFound("id.greaterThan=" + id);

        defaultContractOpportunityShouldBeFound("id.lessThanOrEqual=" + id);
        defaultContractOpportunityShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId equals to DEFAULT_CONTRACT_ID
        defaultContractOpportunityShouldBeFound("contractId.equals=" + DEFAULT_CONTRACT_ID);

        // Get all the contractOpportunityList where contractId equals to UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldNotBeFound("contractId.equals=" + UPDATED_CONTRACT_ID);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId not equals to DEFAULT_CONTRACT_ID
        defaultContractOpportunityShouldNotBeFound("contractId.notEquals=" + DEFAULT_CONTRACT_ID);

        // Get all the contractOpportunityList where contractId not equals to UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldBeFound("contractId.notEquals=" + UPDATED_CONTRACT_ID);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId in DEFAULT_CONTRACT_ID or UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldBeFound("contractId.in=" + DEFAULT_CONTRACT_ID + "," + UPDATED_CONTRACT_ID);

        // Get all the contractOpportunityList where contractId equals to UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldNotBeFound("contractId.in=" + UPDATED_CONTRACT_ID);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId is not null
        defaultContractOpportunityShouldBeFound("contractId.specified=true");

        // Get all the contractOpportunityList where contractId is null
        defaultContractOpportunityShouldNotBeFound("contractId.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId contains DEFAULT_CONTRACT_ID
        defaultContractOpportunityShouldBeFound("contractId.contains=" + DEFAULT_CONTRACT_ID);

        // Get all the contractOpportunityList where contractId contains UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldNotBeFound("contractId.contains=" + UPDATED_CONTRACT_ID);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByContractIdNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where contractId does not contain DEFAULT_CONTRACT_ID
        defaultContractOpportunityShouldNotBeFound("contractId.doesNotContain=" + DEFAULT_CONTRACT_ID);

        // Get all the contractOpportunityList where contractId does not contain UPDATED_CONTRACT_ID
        defaultContractOpportunityShouldBeFound("contractId.doesNotContain=" + UPDATED_CONTRACT_ID);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title equals to DEFAULT_TITLE
        defaultContractOpportunityShouldBeFound("title.equals=" + DEFAULT_TITLE);

        // Get all the contractOpportunityList where title equals to UPDATED_TITLE
        defaultContractOpportunityShouldNotBeFound("title.equals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title not equals to DEFAULT_TITLE
        defaultContractOpportunityShouldNotBeFound("title.notEquals=" + DEFAULT_TITLE);

        // Get all the contractOpportunityList where title not equals to UPDATED_TITLE
        defaultContractOpportunityShouldBeFound("title.notEquals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title in DEFAULT_TITLE or UPDATED_TITLE
        defaultContractOpportunityShouldBeFound("title.in=" + DEFAULT_TITLE + "," + UPDATED_TITLE);

        // Get all the contractOpportunityList where title equals to UPDATED_TITLE
        defaultContractOpportunityShouldNotBeFound("title.in=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title is not null
        defaultContractOpportunityShouldBeFound("title.specified=true");

        // Get all the contractOpportunityList where title is null
        defaultContractOpportunityShouldNotBeFound("title.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title contains DEFAULT_TITLE
        defaultContractOpportunityShouldBeFound("title.contains=" + DEFAULT_TITLE);

        // Get all the contractOpportunityList where title contains UPDATED_TITLE
        defaultContractOpportunityShouldNotBeFound("title.contains=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTitleNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where title does not contain DEFAULT_TITLE
        defaultContractOpportunityShouldNotBeFound("title.doesNotContain=" + DEFAULT_TITLE);

        // Get all the contractOpportunityList where title does not contain UPDATED_TITLE
        defaultContractOpportunityShouldBeFound("title.doesNotContain=" + UPDATED_TITLE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesBySolIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol equals to DEFAULT_SOL
        defaultContractOpportunityShouldBeFound("sol.equals=" + DEFAULT_SOL);

        // Get all the contractOpportunityList where sol equals to UPDATED_SOL
        defaultContractOpportunityShouldNotBeFound("sol.equals=" + UPDATED_SOL);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySolIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol not equals to DEFAULT_SOL
        defaultContractOpportunityShouldNotBeFound("sol.notEquals=" + DEFAULT_SOL);

        // Get all the contractOpportunityList where sol not equals to UPDATED_SOL
        defaultContractOpportunityShouldBeFound("sol.notEquals=" + UPDATED_SOL);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySolIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol in DEFAULT_SOL or UPDATED_SOL
        defaultContractOpportunityShouldBeFound("sol.in=" + DEFAULT_SOL + "," + UPDATED_SOL);

        // Get all the contractOpportunityList where sol equals to UPDATED_SOL
        defaultContractOpportunityShouldNotBeFound("sol.in=" + UPDATED_SOL);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySolIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol is not null
        defaultContractOpportunityShouldBeFound("sol.specified=true");

        // Get all the contractOpportunityList where sol is null
        defaultContractOpportunityShouldNotBeFound("sol.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesBySolContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol contains DEFAULT_SOL
        defaultContractOpportunityShouldBeFound("sol.contains=" + DEFAULT_SOL);

        // Get all the contractOpportunityList where sol contains UPDATED_SOL
        defaultContractOpportunityShouldNotBeFound("sol.contains=" + UPDATED_SOL);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySolNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where sol does not contain DEFAULT_SOL
        defaultContractOpportunityShouldNotBeFound("sol.doesNotContain=" + DEFAULT_SOL);

        // Get all the contractOpportunityList where sol does not contain UPDATED_SOL
        defaultContractOpportunityShouldBeFound("sol.doesNotContain=" + UPDATED_SOL);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency equals to DEFAULT_AGENCY
        defaultContractOpportunityShouldBeFound("agency.equals=" + DEFAULT_AGENCY);

        // Get all the contractOpportunityList where agency equals to UPDATED_AGENCY
        defaultContractOpportunityShouldNotBeFound("agency.equals=" + UPDATED_AGENCY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency not equals to DEFAULT_AGENCY
        defaultContractOpportunityShouldNotBeFound("agency.notEquals=" + DEFAULT_AGENCY);

        // Get all the contractOpportunityList where agency not equals to UPDATED_AGENCY
        defaultContractOpportunityShouldBeFound("agency.notEquals=" + UPDATED_AGENCY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency in DEFAULT_AGENCY or UPDATED_AGENCY
        defaultContractOpportunityShouldBeFound("agency.in=" + DEFAULT_AGENCY + "," + UPDATED_AGENCY);

        // Get all the contractOpportunityList where agency equals to UPDATED_AGENCY
        defaultContractOpportunityShouldNotBeFound("agency.in=" + UPDATED_AGENCY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency is not null
        defaultContractOpportunityShouldBeFound("agency.specified=true");

        // Get all the contractOpportunityList where agency is null
        defaultContractOpportunityShouldNotBeFound("agency.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency contains DEFAULT_AGENCY
        defaultContractOpportunityShouldBeFound("agency.contains=" + DEFAULT_AGENCY);

        // Get all the contractOpportunityList where agency contains UPDATED_AGENCY
        defaultContractOpportunityShouldNotBeFound("agency.contains=" + UPDATED_AGENCY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByAgencyNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where agency does not contain DEFAULT_AGENCY
        defaultContractOpportunityShouldNotBeFound("agency.doesNotContain=" + DEFAULT_AGENCY);

        // Get all the contractOpportunityList where agency does not contain UPDATED_AGENCY
        defaultContractOpportunityShouldBeFound("agency.doesNotContain=" + UPDATED_AGENCY);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier equals to DEFAULT_SUB_TIER
        defaultContractOpportunityShouldBeFound("subTier.equals=" + DEFAULT_SUB_TIER);

        // Get all the contractOpportunityList where subTier equals to UPDATED_SUB_TIER
        defaultContractOpportunityShouldNotBeFound("subTier.equals=" + UPDATED_SUB_TIER);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier not equals to DEFAULT_SUB_TIER
        defaultContractOpportunityShouldNotBeFound("subTier.notEquals=" + DEFAULT_SUB_TIER);

        // Get all the contractOpportunityList where subTier not equals to UPDATED_SUB_TIER
        defaultContractOpportunityShouldBeFound("subTier.notEquals=" + UPDATED_SUB_TIER);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier in DEFAULT_SUB_TIER or UPDATED_SUB_TIER
        defaultContractOpportunityShouldBeFound("subTier.in=" + DEFAULT_SUB_TIER + "," + UPDATED_SUB_TIER);

        // Get all the contractOpportunityList where subTier equals to UPDATED_SUB_TIER
        defaultContractOpportunityShouldNotBeFound("subTier.in=" + UPDATED_SUB_TIER);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier is not null
        defaultContractOpportunityShouldBeFound("subTier.specified=true");

        // Get all the contractOpportunityList where subTier is null
        defaultContractOpportunityShouldNotBeFound("subTier.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier contains DEFAULT_SUB_TIER
        defaultContractOpportunityShouldBeFound("subTier.contains=" + DEFAULT_SUB_TIER);

        // Get all the contractOpportunityList where subTier contains UPDATED_SUB_TIER
        defaultContractOpportunityShouldNotBeFound("subTier.contains=" + UPDATED_SUB_TIER);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySubTierNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where subTier does not contain DEFAULT_SUB_TIER
        defaultContractOpportunityShouldNotBeFound("subTier.doesNotContain=" + DEFAULT_SUB_TIER);

        // Get all the contractOpportunityList where subTier does not contain UPDATED_SUB_TIER
        defaultContractOpportunityShouldBeFound("subTier.doesNotContain=" + UPDATED_SUB_TIER);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office equals to DEFAULT_OFFICE
        defaultContractOpportunityShouldBeFound("office.equals=" + DEFAULT_OFFICE);

        // Get all the contractOpportunityList where office equals to UPDATED_OFFICE
        defaultContractOpportunityShouldNotBeFound("office.equals=" + UPDATED_OFFICE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office not equals to DEFAULT_OFFICE
        defaultContractOpportunityShouldNotBeFound("office.notEquals=" + DEFAULT_OFFICE);

        // Get all the contractOpportunityList where office not equals to UPDATED_OFFICE
        defaultContractOpportunityShouldBeFound("office.notEquals=" + UPDATED_OFFICE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office in DEFAULT_OFFICE or UPDATED_OFFICE
        defaultContractOpportunityShouldBeFound("office.in=" + DEFAULT_OFFICE + "," + UPDATED_OFFICE);

        // Get all the contractOpportunityList where office equals to UPDATED_OFFICE
        defaultContractOpportunityShouldNotBeFound("office.in=" + UPDATED_OFFICE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office is not null
        defaultContractOpportunityShouldBeFound("office.specified=true");

        // Get all the contractOpportunityList where office is null
        defaultContractOpportunityShouldNotBeFound("office.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office contains DEFAULT_OFFICE
        defaultContractOpportunityShouldBeFound("office.contains=" + DEFAULT_OFFICE);

        // Get all the contractOpportunityList where office contains UPDATED_OFFICE
        defaultContractOpportunityShouldNotBeFound("office.contains=" + UPDATED_OFFICE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOfficeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where office does not contain DEFAULT_OFFICE
        defaultContractOpportunityShouldNotBeFound("office.doesNotContain=" + DEFAULT_OFFICE);

        // Get all the contractOpportunityList where office does not contain UPDATED_OFFICE
        defaultContractOpportunityShouldBeFound("office.doesNotContain=" + UPDATED_OFFICE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate equals to DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.equals=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate equals to UPDATED_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.equals=" + UPDATED_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate not equals to DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.notEquals=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate not equals to UPDATED_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.notEquals=" + UPDATED_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate in DEFAULT_POSTEDDATE or UPDATED_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.in=" + DEFAULT_POSTEDDATE + "," + UPDATED_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate equals to UPDATED_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.in=" + UPDATED_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate is not null
        defaultContractOpportunityShouldBeFound("posteddate.specified=true");

        // Get all the contractOpportunityList where posteddate is null
        defaultContractOpportunityShouldNotBeFound("posteddate.specified=false");
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate is greater than or equal to DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.greaterThanOrEqual=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate is greater than or equal to UPDATED_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.greaterThanOrEqual=" + UPDATED_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate is less than or equal to DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.lessThanOrEqual=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate is less than or equal to SMALLER_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.lessThanOrEqual=" + SMALLER_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsLessThanSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate is less than DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.lessThan=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate is less than UPDATED_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.lessThan=" + UPDATED_POSTEDDATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPosteddateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where posteddate is greater than DEFAULT_POSTEDDATE
        defaultContractOpportunityShouldNotBeFound("posteddate.greaterThan=" + DEFAULT_POSTEDDATE);

        // Get all the contractOpportunityList where posteddate is greater than SMALLER_POSTEDDATE
        defaultContractOpportunityShouldBeFound("posteddate.greaterThan=" + SMALLER_POSTEDDATE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type equals to DEFAULT_TYPE
        defaultContractOpportunityShouldBeFound("type.equals=" + DEFAULT_TYPE);

        // Get all the contractOpportunityList where type equals to UPDATED_TYPE
        defaultContractOpportunityShouldNotBeFound("type.equals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type not equals to DEFAULT_TYPE
        defaultContractOpportunityShouldNotBeFound("type.notEquals=" + DEFAULT_TYPE);

        // Get all the contractOpportunityList where type not equals to UPDATED_TYPE
        defaultContractOpportunityShouldBeFound("type.notEquals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type in DEFAULT_TYPE or UPDATED_TYPE
        defaultContractOpportunityShouldBeFound("type.in=" + DEFAULT_TYPE + "," + UPDATED_TYPE);

        // Get all the contractOpportunityList where type equals to UPDATED_TYPE
        defaultContractOpportunityShouldNotBeFound("type.in=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type is not null
        defaultContractOpportunityShouldBeFound("type.specified=true");

        // Get all the contractOpportunityList where type is null
        defaultContractOpportunityShouldNotBeFound("type.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type contains DEFAULT_TYPE
        defaultContractOpportunityShouldBeFound("type.contains=" + DEFAULT_TYPE);

        // Get all the contractOpportunityList where type contains UPDATED_TYPE
        defaultContractOpportunityShouldNotBeFound("type.contains=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByTypeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where type does not contain DEFAULT_TYPE
        defaultContractOpportunityShouldNotBeFound("type.doesNotContain=" + DEFAULT_TYPE);

        // Get all the contractOpportunityList where type does not contain UPDATED_TYPE
        defaultContractOpportunityShouldBeFound("type.doesNotContain=" + UPDATED_TYPE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype equals to DEFAULT_BASETYPE
        defaultContractOpportunityShouldBeFound("basetype.equals=" + DEFAULT_BASETYPE);

        // Get all the contractOpportunityList where basetype equals to UPDATED_BASETYPE
        defaultContractOpportunityShouldNotBeFound("basetype.equals=" + UPDATED_BASETYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype not equals to DEFAULT_BASETYPE
        defaultContractOpportunityShouldNotBeFound("basetype.notEquals=" + DEFAULT_BASETYPE);

        // Get all the contractOpportunityList where basetype not equals to UPDATED_BASETYPE
        defaultContractOpportunityShouldBeFound("basetype.notEquals=" + UPDATED_BASETYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype in DEFAULT_BASETYPE or UPDATED_BASETYPE
        defaultContractOpportunityShouldBeFound("basetype.in=" + DEFAULT_BASETYPE + "," + UPDATED_BASETYPE);

        // Get all the contractOpportunityList where basetype equals to UPDATED_BASETYPE
        defaultContractOpportunityShouldNotBeFound("basetype.in=" + UPDATED_BASETYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype is not null
        defaultContractOpportunityShouldBeFound("basetype.specified=true");

        // Get all the contractOpportunityList where basetype is null
        defaultContractOpportunityShouldNotBeFound("basetype.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype contains DEFAULT_BASETYPE
        defaultContractOpportunityShouldBeFound("basetype.contains=" + DEFAULT_BASETYPE);

        // Get all the contractOpportunityList where basetype contains UPDATED_BASETYPE
        defaultContractOpportunityShouldNotBeFound("basetype.contains=" + UPDATED_BASETYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByBasetypeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where basetype does not contain DEFAULT_BASETYPE
        defaultContractOpportunityShouldNotBeFound("basetype.doesNotContain=" + DEFAULT_BASETYPE);

        // Get all the contractOpportunityList where basetype does not contain UPDATED_BASETYPE
        defaultContractOpportunityShouldBeFound("basetype.doesNotContain=" + UPDATED_BASETYPE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode equals to DEFAULT_SETASIDECODE
        defaultContractOpportunityShouldBeFound("setasidecode.equals=" + DEFAULT_SETASIDECODE);

        // Get all the contractOpportunityList where setasidecode equals to UPDATED_SETASIDECODE
        defaultContractOpportunityShouldNotBeFound("setasidecode.equals=" + UPDATED_SETASIDECODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode not equals to DEFAULT_SETASIDECODE
        defaultContractOpportunityShouldNotBeFound("setasidecode.notEquals=" + DEFAULT_SETASIDECODE);

        // Get all the contractOpportunityList where setasidecode not equals to UPDATED_SETASIDECODE
        defaultContractOpportunityShouldBeFound("setasidecode.notEquals=" + UPDATED_SETASIDECODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode in DEFAULT_SETASIDECODE or UPDATED_SETASIDECODE
        defaultContractOpportunityShouldBeFound("setasidecode.in=" + DEFAULT_SETASIDECODE + "," + UPDATED_SETASIDECODE);

        // Get all the contractOpportunityList where setasidecode equals to UPDATED_SETASIDECODE
        defaultContractOpportunityShouldNotBeFound("setasidecode.in=" + UPDATED_SETASIDECODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode is not null
        defaultContractOpportunityShouldBeFound("setasidecode.specified=true");

        // Get all the contractOpportunityList where setasidecode is null
        defaultContractOpportunityShouldNotBeFound("setasidecode.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode contains DEFAULT_SETASIDECODE
        defaultContractOpportunityShouldBeFound("setasidecode.contains=" + DEFAULT_SETASIDECODE);

        // Get all the contractOpportunityList where setasidecode contains UPDATED_SETASIDECODE
        defaultContractOpportunityShouldNotBeFound("setasidecode.contains=" + UPDATED_SETASIDECODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasidecodeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setasidecode does not contain DEFAULT_SETASIDECODE
        defaultContractOpportunityShouldNotBeFound("setasidecode.doesNotContain=" + DEFAULT_SETASIDECODE);

        // Get all the contractOpportunityList where setasidecode does not contain UPDATED_SETASIDECODE
        defaultContractOpportunityShouldBeFound("setasidecode.doesNotContain=" + UPDATED_SETASIDECODE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside equals to DEFAULT_SETASIDE
        defaultContractOpportunityShouldBeFound("setaside.equals=" + DEFAULT_SETASIDE);

        // Get all the contractOpportunityList where setaside equals to UPDATED_SETASIDE
        defaultContractOpportunityShouldNotBeFound("setaside.equals=" + UPDATED_SETASIDE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside not equals to DEFAULT_SETASIDE
        defaultContractOpportunityShouldNotBeFound("setaside.notEquals=" + DEFAULT_SETASIDE);

        // Get all the contractOpportunityList where setaside not equals to UPDATED_SETASIDE
        defaultContractOpportunityShouldBeFound("setaside.notEquals=" + UPDATED_SETASIDE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside in DEFAULT_SETASIDE or UPDATED_SETASIDE
        defaultContractOpportunityShouldBeFound("setaside.in=" + DEFAULT_SETASIDE + "," + UPDATED_SETASIDE);

        // Get all the contractOpportunityList where setaside equals to UPDATED_SETASIDE
        defaultContractOpportunityShouldNotBeFound("setaside.in=" + UPDATED_SETASIDE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside is not null
        defaultContractOpportunityShouldBeFound("setaside.specified=true");

        // Get all the contractOpportunityList where setaside is null
        defaultContractOpportunityShouldNotBeFound("setaside.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside contains DEFAULT_SETASIDE
        defaultContractOpportunityShouldBeFound("setaside.contains=" + DEFAULT_SETASIDE);

        // Get all the contractOpportunityList where setaside contains UPDATED_SETASIDE
        defaultContractOpportunityShouldNotBeFound("setaside.contains=" + UPDATED_SETASIDE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesBySetasideNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where setaside does not contain DEFAULT_SETASIDE
        defaultContractOpportunityShouldNotBeFound("setaside.doesNotContain=" + DEFAULT_SETASIDE);

        // Get all the contractOpportunityList where setaside does not contain UPDATED_SETASIDE
        defaultContractOpportunityShouldBeFound("setaside.doesNotContain=" + UPDATED_SETASIDE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline equals to DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.equals=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline equals to UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.equals=" + UPDATED_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline not equals to DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.notEquals=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline not equals to UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.notEquals=" + UPDATED_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline in DEFAULT_RESPONSEDEADLINE or UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.in=" + DEFAULT_RESPONSEDEADLINE + "," + UPDATED_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline equals to UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.in=" + UPDATED_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline is not null
        defaultContractOpportunityShouldBeFound("responsedeadline.specified=true");

        // Get all the contractOpportunityList where responsedeadline is null
        defaultContractOpportunityShouldNotBeFound("responsedeadline.specified=false");
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline is greater than or equal to DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.greaterThanOrEqual=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline is greater than or equal to UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.greaterThanOrEqual=" + UPDATED_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline is less than or equal to DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.lessThanOrEqual=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline is less than or equal to SMALLER_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.lessThanOrEqual=" + SMALLER_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsLessThanSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline is less than DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.lessThan=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline is less than UPDATED_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.lessThan=" + UPDATED_RESPONSEDEADLINE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByResponsedeadlineIsGreaterThanSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where responsedeadline is greater than DEFAULT_RESPONSEDEADLINE
        defaultContractOpportunityShouldNotBeFound("responsedeadline.greaterThan=" + DEFAULT_RESPONSEDEADLINE);

        // Get all the contractOpportunityList where responsedeadline is greater than SMALLER_RESPONSEDEADLINE
        defaultContractOpportunityShouldBeFound("responsedeadline.greaterThan=" + SMALLER_RESPONSEDEADLINE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode equals to DEFAULT_NAICSCODE
        defaultContractOpportunityShouldBeFound("naicscode.equals=" + DEFAULT_NAICSCODE);

        // Get all the contractOpportunityList where naicscode equals to UPDATED_NAICSCODE
        defaultContractOpportunityShouldNotBeFound("naicscode.equals=" + UPDATED_NAICSCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode not equals to DEFAULT_NAICSCODE
        defaultContractOpportunityShouldNotBeFound("naicscode.notEquals=" + DEFAULT_NAICSCODE);

        // Get all the contractOpportunityList where naicscode not equals to UPDATED_NAICSCODE
        defaultContractOpportunityShouldBeFound("naicscode.notEquals=" + UPDATED_NAICSCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode in DEFAULT_NAICSCODE or UPDATED_NAICSCODE
        defaultContractOpportunityShouldBeFound("naicscode.in=" + DEFAULT_NAICSCODE + "," + UPDATED_NAICSCODE);

        // Get all the contractOpportunityList where naicscode equals to UPDATED_NAICSCODE
        defaultContractOpportunityShouldNotBeFound("naicscode.in=" + UPDATED_NAICSCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode is not null
        defaultContractOpportunityShouldBeFound("naicscode.specified=true");

        // Get all the contractOpportunityList where naicscode is null
        defaultContractOpportunityShouldNotBeFound("naicscode.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode contains DEFAULT_NAICSCODE
        defaultContractOpportunityShouldBeFound("naicscode.contains=" + DEFAULT_NAICSCODE);

        // Get all the contractOpportunityList where naicscode contains UPDATED_NAICSCODE
        defaultContractOpportunityShouldNotBeFound("naicscode.contains=" + UPDATED_NAICSCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByNaicscodeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where naicscode does not contain DEFAULT_NAICSCODE
        defaultContractOpportunityShouldNotBeFound("naicscode.doesNotContain=" + DEFAULT_NAICSCODE);

        // Get all the contractOpportunityList where naicscode does not contain UPDATED_NAICSCODE
        defaultContractOpportunityShouldBeFound("naicscode.doesNotContain=" + UPDATED_NAICSCODE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode equals to DEFAULT_CLASSIFICATIONCODE
        defaultContractOpportunityShouldBeFound("classificationcode.equals=" + DEFAULT_CLASSIFICATIONCODE);

        // Get all the contractOpportunityList where classificationcode equals to UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldNotBeFound("classificationcode.equals=" + UPDATED_CLASSIFICATIONCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode not equals to DEFAULT_CLASSIFICATIONCODE
        defaultContractOpportunityShouldNotBeFound("classificationcode.notEquals=" + DEFAULT_CLASSIFICATIONCODE);

        // Get all the contractOpportunityList where classificationcode not equals to UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldBeFound("classificationcode.notEquals=" + UPDATED_CLASSIFICATIONCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode in DEFAULT_CLASSIFICATIONCODE or UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldBeFound("classificationcode.in=" + DEFAULT_CLASSIFICATIONCODE + "," + UPDATED_CLASSIFICATIONCODE);

        // Get all the contractOpportunityList where classificationcode equals to UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldNotBeFound("classificationcode.in=" + UPDATED_CLASSIFICATIONCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode is not null
        defaultContractOpportunityShouldBeFound("classificationcode.specified=true");

        // Get all the contractOpportunityList where classificationcode is null
        defaultContractOpportunityShouldNotBeFound("classificationcode.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode contains DEFAULT_CLASSIFICATIONCODE
        defaultContractOpportunityShouldBeFound("classificationcode.contains=" + DEFAULT_CLASSIFICATIONCODE);

        // Get all the contractOpportunityList where classificationcode contains UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldNotBeFound("classificationcode.contains=" + UPDATED_CLASSIFICATIONCODE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByClassificationcodeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where classificationcode does not contain DEFAULT_CLASSIFICATIONCODE
        defaultContractOpportunityShouldNotBeFound("classificationcode.doesNotContain=" + DEFAULT_CLASSIFICATIONCODE);

        // Get all the contractOpportunityList where classificationcode does not contain UPDATED_CLASSIFICATIONCODE
        defaultContractOpportunityShouldBeFound("classificationcode.doesNotContain=" + UPDATED_CLASSIFICATIONCODE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate equals to DEFAULT_POPSTATE
        defaultContractOpportunityShouldBeFound("popstate.equals=" + DEFAULT_POPSTATE);

        // Get all the contractOpportunityList where popstate equals to UPDATED_POPSTATE
        defaultContractOpportunityShouldNotBeFound("popstate.equals=" + UPDATED_POPSTATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate not equals to DEFAULT_POPSTATE
        defaultContractOpportunityShouldNotBeFound("popstate.notEquals=" + DEFAULT_POPSTATE);

        // Get all the contractOpportunityList where popstate not equals to UPDATED_POPSTATE
        defaultContractOpportunityShouldBeFound("popstate.notEquals=" + UPDATED_POPSTATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate in DEFAULT_POPSTATE or UPDATED_POPSTATE
        defaultContractOpportunityShouldBeFound("popstate.in=" + DEFAULT_POPSTATE + "," + UPDATED_POPSTATE);

        // Get all the contractOpportunityList where popstate equals to UPDATED_POPSTATE
        defaultContractOpportunityShouldNotBeFound("popstate.in=" + UPDATED_POPSTATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate is not null
        defaultContractOpportunityShouldBeFound("popstate.specified=true");

        // Get all the contractOpportunityList where popstate is null
        defaultContractOpportunityShouldNotBeFound("popstate.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate contains DEFAULT_POPSTATE
        defaultContractOpportunityShouldBeFound("popstate.contains=" + DEFAULT_POPSTATE);

        // Get all the contractOpportunityList where popstate contains UPDATED_POPSTATE
        defaultContractOpportunityShouldNotBeFound("popstate.contains=" + UPDATED_POPSTATE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopstateNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popstate does not contain DEFAULT_POPSTATE
        defaultContractOpportunityShouldNotBeFound("popstate.doesNotContain=" + DEFAULT_POPSTATE);

        // Get all the contractOpportunityList where popstate does not contain UPDATED_POPSTATE
        defaultContractOpportunityShouldBeFound("popstate.doesNotContain=" + UPDATED_POPSTATE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip equals to DEFAULT_POPZIP
        defaultContractOpportunityShouldBeFound("popzip.equals=" + DEFAULT_POPZIP);

        // Get all the contractOpportunityList where popzip equals to UPDATED_POPZIP
        defaultContractOpportunityShouldNotBeFound("popzip.equals=" + UPDATED_POPZIP);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip not equals to DEFAULT_POPZIP
        defaultContractOpportunityShouldNotBeFound("popzip.notEquals=" + DEFAULT_POPZIP);

        // Get all the contractOpportunityList where popzip not equals to UPDATED_POPZIP
        defaultContractOpportunityShouldBeFound("popzip.notEquals=" + UPDATED_POPZIP);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip in DEFAULT_POPZIP or UPDATED_POPZIP
        defaultContractOpportunityShouldBeFound("popzip.in=" + DEFAULT_POPZIP + "," + UPDATED_POPZIP);

        // Get all the contractOpportunityList where popzip equals to UPDATED_POPZIP
        defaultContractOpportunityShouldNotBeFound("popzip.in=" + UPDATED_POPZIP);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip is not null
        defaultContractOpportunityShouldBeFound("popzip.specified=true");

        // Get all the contractOpportunityList where popzip is null
        defaultContractOpportunityShouldNotBeFound("popzip.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip contains DEFAULT_POPZIP
        defaultContractOpportunityShouldBeFound("popzip.contains=" + DEFAULT_POPZIP);

        // Get all the contractOpportunityList where popzip contains UPDATED_POPZIP
        defaultContractOpportunityShouldNotBeFound("popzip.contains=" + UPDATED_POPZIP);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopzipNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popzip does not contain DEFAULT_POPZIP
        defaultContractOpportunityShouldNotBeFound("popzip.doesNotContain=" + DEFAULT_POPZIP);

        // Get all the contractOpportunityList where popzip does not contain UPDATED_POPZIP
        defaultContractOpportunityShouldBeFound("popzip.doesNotContain=" + UPDATED_POPZIP);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry equals to DEFAULT_POPCOUNTRY
        defaultContractOpportunityShouldBeFound("popcountry.equals=" + DEFAULT_POPCOUNTRY);

        // Get all the contractOpportunityList where popcountry equals to UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldNotBeFound("popcountry.equals=" + UPDATED_POPCOUNTRY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry not equals to DEFAULT_POPCOUNTRY
        defaultContractOpportunityShouldNotBeFound("popcountry.notEquals=" + DEFAULT_POPCOUNTRY);

        // Get all the contractOpportunityList where popcountry not equals to UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldBeFound("popcountry.notEquals=" + UPDATED_POPCOUNTRY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry in DEFAULT_POPCOUNTRY or UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldBeFound("popcountry.in=" + DEFAULT_POPCOUNTRY + "," + UPDATED_POPCOUNTRY);

        // Get all the contractOpportunityList where popcountry equals to UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldNotBeFound("popcountry.in=" + UPDATED_POPCOUNTRY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry is not null
        defaultContractOpportunityShouldBeFound("popcountry.specified=true");

        // Get all the contractOpportunityList where popcountry is null
        defaultContractOpportunityShouldNotBeFound("popcountry.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry contains DEFAULT_POPCOUNTRY
        defaultContractOpportunityShouldBeFound("popcountry.contains=" + DEFAULT_POPCOUNTRY);

        // Get all the contractOpportunityList where popcountry contains UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldNotBeFound("popcountry.contains=" + UPDATED_POPCOUNTRY);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByPopcountryNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where popcountry does not contain DEFAULT_POPCOUNTRY
        defaultContractOpportunityShouldNotBeFound("popcountry.doesNotContain=" + DEFAULT_POPCOUNTRY);

        // Get all the contractOpportunityList where popcountry does not contain UPDATED_POPCOUNTRY
        defaultContractOpportunityShouldBeFound("popcountry.doesNotContain=" + UPDATED_POPCOUNTRY);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active equals to DEFAULT_ACTIVE
        defaultContractOpportunityShouldBeFound("active.equals=" + DEFAULT_ACTIVE);

        // Get all the contractOpportunityList where active equals to UPDATED_ACTIVE
        defaultContractOpportunityShouldNotBeFound("active.equals=" + UPDATED_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active not equals to DEFAULT_ACTIVE
        defaultContractOpportunityShouldNotBeFound("active.notEquals=" + DEFAULT_ACTIVE);

        // Get all the contractOpportunityList where active not equals to UPDATED_ACTIVE
        defaultContractOpportunityShouldBeFound("active.notEquals=" + UPDATED_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active in DEFAULT_ACTIVE or UPDATED_ACTIVE
        defaultContractOpportunityShouldBeFound("active.in=" + DEFAULT_ACTIVE + "," + UPDATED_ACTIVE);

        // Get all the contractOpportunityList where active equals to UPDATED_ACTIVE
        defaultContractOpportunityShouldNotBeFound("active.in=" + UPDATED_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active is not null
        defaultContractOpportunityShouldBeFound("active.specified=true");

        // Get all the contractOpportunityList where active is null
        defaultContractOpportunityShouldNotBeFound("active.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active contains DEFAULT_ACTIVE
        defaultContractOpportunityShouldBeFound("active.contains=" + DEFAULT_ACTIVE);

        // Get all the contractOpportunityList where active contains UPDATED_ACTIVE
        defaultContractOpportunityShouldNotBeFound("active.contains=" + UPDATED_ACTIVE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByActiveNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where active does not contain DEFAULT_ACTIVE
        defaultContractOpportunityShouldNotBeFound("active.doesNotContain=" + DEFAULT_ACTIVE);

        // Get all the contractOpportunityList where active does not contain UPDATED_ACTIVE
        defaultContractOpportunityShouldBeFound("active.doesNotContain=" + UPDATED_ACTIVE);
    }


    @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeIsEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype equals to DEFAULT_ORGANIZATIONTYPE
        defaultContractOpportunityShouldBeFound("organizationtype.equals=" + DEFAULT_ORGANIZATIONTYPE);

        // Get all the contractOpportunityList where organizationtype equals to UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldNotBeFound("organizationtype.equals=" + UPDATED_ORGANIZATIONTYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype not equals to DEFAULT_ORGANIZATIONTYPE
        defaultContractOpportunityShouldNotBeFound("organizationtype.notEquals=" + DEFAULT_ORGANIZATIONTYPE);

        // Get all the contractOpportunityList where organizationtype not equals to UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldBeFound("organizationtype.notEquals=" + UPDATED_ORGANIZATIONTYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeIsInShouldWork() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype in DEFAULT_ORGANIZATIONTYPE or UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldBeFound("organizationtype.in=" + DEFAULT_ORGANIZATIONTYPE + "," + UPDATED_ORGANIZATIONTYPE);

        // Get all the contractOpportunityList where organizationtype equals to UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldNotBeFound("organizationtype.in=" + UPDATED_ORGANIZATIONTYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype is not null
        defaultContractOpportunityShouldBeFound("organizationtype.specified=true");

        // Get all the contractOpportunityList where organizationtype is null
        defaultContractOpportunityShouldNotBeFound("organizationtype.specified=false");
    }
                @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype contains DEFAULT_ORGANIZATIONTYPE
        defaultContractOpportunityShouldBeFound("organizationtype.contains=" + DEFAULT_ORGANIZATIONTYPE);

        // Get all the contractOpportunityList where organizationtype contains UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldNotBeFound("organizationtype.contains=" + UPDATED_ORGANIZATIONTYPE);
    }

    @Test
    @Transactional
    public void getAllContractOpportunitiesByOrganizationtypeNotContainsSomething() throws Exception {
        // Initialize the database
        contractOpportunityRepository.saveAndFlush(contractOpportunity);

        // Get all the contractOpportunityList where organizationtype does not contain DEFAULT_ORGANIZATIONTYPE
        defaultContractOpportunityShouldNotBeFound("organizationtype.doesNotContain=" + DEFAULT_ORGANIZATIONTYPE);

        // Get all the contractOpportunityList where organizationtype does not contain UPDATED_ORGANIZATIONTYPE
        defaultContractOpportunityShouldBeFound("organizationtype.doesNotContain=" + UPDATED_ORGANIZATIONTYPE);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultContractOpportunityShouldBeFound(String filter) throws Exception {
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(contractOpportunity.getId().intValue())))
            .andExpect(jsonPath("$.[*].contractId").value(hasItem(DEFAULT_CONTRACT_ID)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].sol").value(hasItem(DEFAULT_SOL)))
            .andExpect(jsonPath("$.[*].agency").value(hasItem(DEFAULT_AGENCY)))
            .andExpect(jsonPath("$.[*].subTier").value(hasItem(DEFAULT_SUB_TIER)))
            .andExpect(jsonPath("$.[*].office").value(hasItem(DEFAULT_OFFICE)))
            .andExpect(jsonPath("$.[*].posteddate").value(hasItem(DEFAULT_POSTEDDATE.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].basetype").value(hasItem(DEFAULT_BASETYPE)))
            .andExpect(jsonPath("$.[*].setasidecode").value(hasItem(DEFAULT_SETASIDECODE)))
            .andExpect(jsonPath("$.[*].setaside").value(hasItem(DEFAULT_SETASIDE)))
            .andExpect(jsonPath("$.[*].responsedeadline").value(hasItem(DEFAULT_RESPONSEDEADLINE.toString())))
            .andExpect(jsonPath("$.[*].naicscode").value(hasItem(DEFAULT_NAICSCODE)))
            .andExpect(jsonPath("$.[*].classificationcode").value(hasItem(DEFAULT_CLASSIFICATIONCODE)))
            .andExpect(jsonPath("$.[*].popstate").value(hasItem(DEFAULT_POPSTATE)))
            .andExpect(jsonPath("$.[*].popzip").value(hasItem(DEFAULT_POPZIP)))
            .andExpect(jsonPath("$.[*].popcountry").value(hasItem(DEFAULT_POPCOUNTRY)))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE)))
            .andExpect(jsonPath("$.[*].organizationtype").value(hasItem(DEFAULT_ORGANIZATIONTYPE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())));

        // Check, that the count call also returns 1
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultContractOpportunityShouldNotBeFound(String filter) throws Exception {
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingContractOpportunity() throws Exception {
        // Get the contractOpportunity
        restContractOpportunityMockMvc.perform(get("/api/contract-opportunities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }
}
