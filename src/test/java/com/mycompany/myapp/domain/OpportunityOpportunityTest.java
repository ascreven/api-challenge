package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class OpportunityOpportunityTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OpportunityOpportunity.class);
        OpportunityOpportunity opportunityOpportunity1 = new OpportunityOpportunity();
        opportunityOpportunity1.setId(1L);
        OpportunityOpportunity opportunityOpportunity2 = new OpportunityOpportunity();
        opportunityOpportunity2.setId(opportunityOpportunity1.getId());
        assertThat(opportunityOpportunity1).isEqualTo(opportunityOpportunity2);
        opportunityOpportunity2.setId(2L);
        assertThat(opportunityOpportunity1).isNotEqualTo(opportunityOpportunity2);
        opportunityOpportunity1.setId(null);
        assertThat(opportunityOpportunity1).isNotEqualTo(opportunityOpportunity2);
    }
}
