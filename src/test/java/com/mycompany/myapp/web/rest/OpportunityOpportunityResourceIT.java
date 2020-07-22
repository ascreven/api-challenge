package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.OpportunitiesApp;
import com.mycompany.myapp.domain.OpportunityOpportunity;
import com.mycompany.myapp.repository.OpportunityOpportunityRepository;

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
 * Integration tests for the {@link OpportunityOpportunityResource} REST controller.
 */
@SpringBootTest(classes = OpportunitiesApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class OpportunityOpportunityResourceIT {

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
    private OpportunityOpportunityRepository opportunityOpportunityRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restOpportunityOpportunityMockMvc;

    private OpportunityOpportunity opportunityOpportunity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OpportunityOpportunity createEntity(EntityManager em) {
        OpportunityOpportunity opportunityOpportunity = new OpportunityOpportunity()
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
        return opportunityOpportunity;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OpportunityOpportunity createUpdatedEntity(EntityManager em) {
        OpportunityOpportunity opportunityOpportunity = new OpportunityOpportunity()
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
        return opportunityOpportunity;
    }

    @BeforeEach
    public void initTest() {
        opportunityOpportunity = createEntity(em);
    }

    @Test
    @Transactional
    public void createOpportunityOpportunity() throws Exception {
        int databaseSizeBeforeCreate = opportunityOpportunityRepository.findAll().size();
        // Create the OpportunityOpportunity
        restOpportunityOpportunityMockMvc.perform(post("/api/opportunity-opportunities")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(opportunityOpportunity)))
            .andExpect(status().isCreated());

        // Validate the OpportunityOpportunity in the database
        List<OpportunityOpportunity> opportunityOpportunityList = opportunityOpportunityRepository.findAll();
        assertThat(opportunityOpportunityList).hasSize(databaseSizeBeforeCreate + 1);
        OpportunityOpportunity testOpportunityOpportunity = opportunityOpportunityList.get(opportunityOpportunityList.size() - 1);
        assertThat(testOpportunityOpportunity.getContractId()).isEqualTo(DEFAULT_CONTRACT_ID);
        assertThat(testOpportunityOpportunity.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testOpportunityOpportunity.getSol()).isEqualTo(DEFAULT_SOL);
        assertThat(testOpportunityOpportunity.getAgency()).isEqualTo(DEFAULT_AGENCY);
        assertThat(testOpportunityOpportunity.getSubTier()).isEqualTo(DEFAULT_SUB_TIER);
        assertThat(testOpportunityOpportunity.getOffice()).isEqualTo(DEFAULT_OFFICE);
        assertThat(testOpportunityOpportunity.getPosteddate()).isEqualTo(DEFAULT_POSTEDDATE);
        assertThat(testOpportunityOpportunity.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testOpportunityOpportunity.getBasetype()).isEqualTo(DEFAULT_BASETYPE);
        assertThat(testOpportunityOpportunity.getSetasidecode()).isEqualTo(DEFAULT_SETASIDECODE);
        assertThat(testOpportunityOpportunity.getSetaside()).isEqualTo(DEFAULT_SETASIDE);
        assertThat(testOpportunityOpportunity.getResponsedeadline()).isEqualTo(DEFAULT_RESPONSEDEADLINE);
        assertThat(testOpportunityOpportunity.getNaicscode()).isEqualTo(DEFAULT_NAICSCODE);
        assertThat(testOpportunityOpportunity.getClassificationcode()).isEqualTo(DEFAULT_CLASSIFICATIONCODE);
        assertThat(testOpportunityOpportunity.getPopstate()).isEqualTo(DEFAULT_POPSTATE);
        assertThat(testOpportunityOpportunity.getPopzip()).isEqualTo(DEFAULT_POPZIP);
        assertThat(testOpportunityOpportunity.getPopcountry()).isEqualTo(DEFAULT_POPCOUNTRY);
        assertThat(testOpportunityOpportunity.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testOpportunityOpportunity.getOrganizationtype()).isEqualTo(DEFAULT_ORGANIZATIONTYPE);
        assertThat(testOpportunityOpportunity.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void createOpportunityOpportunityWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = opportunityOpportunityRepository.findAll().size();

        // Create the OpportunityOpportunity with an existing ID
        opportunityOpportunity.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restOpportunityOpportunityMockMvc.perform(post("/api/opportunity-opportunities")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(opportunityOpportunity)))
            .andExpect(status().isBadRequest());

        // Validate the OpportunityOpportunity in the database
        List<OpportunityOpportunity> opportunityOpportunityList = opportunityOpportunityRepository.findAll();
        assertThat(opportunityOpportunityList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllOpportunityOpportunities() throws Exception {
        // Initialize the database
        opportunityOpportunityRepository.saveAndFlush(opportunityOpportunity);

        // Get all the opportunityOpportunityList
        restOpportunityOpportunityMockMvc.perform(get("/api/opportunity-opportunities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(opportunityOpportunity.getId().intValue())))
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
    public void getOpportunityOpportunity() throws Exception {
        // Initialize the database
        opportunityOpportunityRepository.saveAndFlush(opportunityOpportunity);

        // Get the opportunityOpportunity
        restOpportunityOpportunityMockMvc.perform(get("/api/opportunity-opportunities/{id}", opportunityOpportunity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(opportunityOpportunity.getId().intValue()))
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
    public void getNonExistingOpportunityOpportunity() throws Exception {
        // Get the opportunityOpportunity
        restOpportunityOpportunityMockMvc.perform(get("/api/opportunity-opportunities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOpportunityOpportunity() throws Exception {
        // Initialize the database
        opportunityOpportunityRepository.saveAndFlush(opportunityOpportunity);

        int databaseSizeBeforeUpdate = opportunityOpportunityRepository.findAll().size();

        // Update the opportunityOpportunity
        OpportunityOpportunity updatedOpportunityOpportunity = opportunityOpportunityRepository.findById(opportunityOpportunity.getId()).get();
        // Disconnect from session so that the updates on updatedOpportunityOpportunity are not directly saved in db
        em.detach(updatedOpportunityOpportunity);
        updatedOpportunityOpportunity
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

        restOpportunityOpportunityMockMvc.perform(put("/api/opportunity-opportunities")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedOpportunityOpportunity)))
            .andExpect(status().isOk());

        // Validate the OpportunityOpportunity in the database
        List<OpportunityOpportunity> opportunityOpportunityList = opportunityOpportunityRepository.findAll();
        assertThat(opportunityOpportunityList).hasSize(databaseSizeBeforeUpdate);
        OpportunityOpportunity testOpportunityOpportunity = opportunityOpportunityList.get(opportunityOpportunityList.size() - 1);
        assertThat(testOpportunityOpportunity.getContractId()).isEqualTo(UPDATED_CONTRACT_ID);
        assertThat(testOpportunityOpportunity.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testOpportunityOpportunity.getSol()).isEqualTo(UPDATED_SOL);
        assertThat(testOpportunityOpportunity.getAgency()).isEqualTo(UPDATED_AGENCY);
        assertThat(testOpportunityOpportunity.getSubTier()).isEqualTo(UPDATED_SUB_TIER);
        assertThat(testOpportunityOpportunity.getOffice()).isEqualTo(UPDATED_OFFICE);
        assertThat(testOpportunityOpportunity.getPosteddate()).isEqualTo(UPDATED_POSTEDDATE);
        assertThat(testOpportunityOpportunity.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testOpportunityOpportunity.getBasetype()).isEqualTo(UPDATED_BASETYPE);
        assertThat(testOpportunityOpportunity.getSetasidecode()).isEqualTo(UPDATED_SETASIDECODE);
        assertThat(testOpportunityOpportunity.getSetaside()).isEqualTo(UPDATED_SETASIDE);
        assertThat(testOpportunityOpportunity.getResponsedeadline()).isEqualTo(UPDATED_RESPONSEDEADLINE);
        assertThat(testOpportunityOpportunity.getNaicscode()).isEqualTo(UPDATED_NAICSCODE);
        assertThat(testOpportunityOpportunity.getClassificationcode()).isEqualTo(UPDATED_CLASSIFICATIONCODE);
        assertThat(testOpportunityOpportunity.getPopstate()).isEqualTo(UPDATED_POPSTATE);
        assertThat(testOpportunityOpportunity.getPopzip()).isEqualTo(UPDATED_POPZIP);
        assertThat(testOpportunityOpportunity.getPopcountry()).isEqualTo(UPDATED_POPCOUNTRY);
        assertThat(testOpportunityOpportunity.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testOpportunityOpportunity.getOrganizationtype()).isEqualTo(UPDATED_ORGANIZATIONTYPE);
        assertThat(testOpportunityOpportunity.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    public void updateNonExistingOpportunityOpportunity() throws Exception {
        int databaseSizeBeforeUpdate = opportunityOpportunityRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOpportunityOpportunityMockMvc.perform(put("/api/opportunity-opportunities")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(opportunityOpportunity)))
            .andExpect(status().isBadRequest());

        // Validate the OpportunityOpportunity in the database
        List<OpportunityOpportunity> opportunityOpportunityList = opportunityOpportunityRepository.findAll();
        assertThat(opportunityOpportunityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteOpportunityOpportunity() throws Exception {
        // Initialize the database
        opportunityOpportunityRepository.saveAndFlush(opportunityOpportunity);

        int databaseSizeBeforeDelete = opportunityOpportunityRepository.findAll().size();

        // Delete the opportunityOpportunity
        restOpportunityOpportunityMockMvc.perform(delete("/api/opportunity-opportunities/{id}", opportunityOpportunity.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<OpportunityOpportunity> opportunityOpportunityList = opportunityOpportunityRepository.findAll();
        assertThat(opportunityOpportunityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
