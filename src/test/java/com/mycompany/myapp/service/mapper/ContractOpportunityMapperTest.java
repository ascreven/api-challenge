package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ContractOpportunityMapperTest {

    private ContractOpportunityMapper contractOpportunityMapper;

    @BeforeEach
    public void setUp() {
        contractOpportunityMapper = new ContractOpportunityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(contractOpportunityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(contractOpportunityMapper.fromId(null)).isNull();
    }
}
