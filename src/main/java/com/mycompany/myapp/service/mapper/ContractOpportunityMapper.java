package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ContractOpportunityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ContractOpportunity} and its DTO {@link ContractOpportunityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ContractOpportunityMapper extends EntityMapper<ContractOpportunityDTO, ContractOpportunity> {



    default ContractOpportunity fromId(Long id) {
        if (id == null) {
            return null;
        }
        ContractOpportunity contractOpportunity = new ContractOpportunity();
        contractOpportunity.setId(id);
        return contractOpportunity;
    }
}
