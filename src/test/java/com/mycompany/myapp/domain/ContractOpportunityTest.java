package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class ContractOpportunityTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContractOpportunity.class);
        ContractOpportunity contractOpportunity1 = new ContractOpportunity();
        contractOpportunity1.setId(1L);
        ContractOpportunity contractOpportunity2 = new ContractOpportunity();
        contractOpportunity2.setId(contractOpportunity1.getId());
        assertThat(contractOpportunity1).isEqualTo(contractOpportunity2);
        contractOpportunity2.setId(2L);
        assertThat(contractOpportunity1).isNotEqualTo(contractOpportunity2);
        contractOpportunity1.setId(null);
        assertThat(contractOpportunity1).isNotEqualTo(contractOpportunity2);
    }
}
