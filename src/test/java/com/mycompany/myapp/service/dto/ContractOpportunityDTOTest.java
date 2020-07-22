package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class ContractOpportunityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContractOpportunityDTO.class);
        ContractOpportunityDTO contractOpportunityDTO1 = new ContractOpportunityDTO();
        contractOpportunityDTO1.setId(1L);
        ContractOpportunityDTO contractOpportunityDTO2 = new ContractOpportunityDTO();
        assertThat(contractOpportunityDTO1).isNotEqualTo(contractOpportunityDTO2);
        contractOpportunityDTO2.setId(contractOpportunityDTO1.getId());
        assertThat(contractOpportunityDTO1).isEqualTo(contractOpportunityDTO2);
        contractOpportunityDTO2.setId(2L);
        assertThat(contractOpportunityDTO1).isNotEqualTo(contractOpportunityDTO2);
        contractOpportunityDTO1.setId(null);
        assertThat(contractOpportunityDTO1).isNotEqualTo(contractOpportunityDTO2);
    }
}
