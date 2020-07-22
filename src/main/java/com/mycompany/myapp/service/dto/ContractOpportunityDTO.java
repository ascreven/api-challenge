package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ContractOpportunity} entity.
 */
public class ContractOpportunityDTO implements Serializable {
    
    private Long id;

    private String contractId;

    @Size(max = 1024)
    private String title;

    private String sol;

    private String agency;

    private String subTier;

    private String office;

    private LocalDate posteddate;

    private String type;

    private String basetype;

    private String setasidecode;

    private String setaside;

    private LocalDate responsedeadline;

    private String naicscode;

    private String classificationcode;

    private String popstate;

    private String popzip;

    private String popcountry;

    private String active;

    private String organizationtype;

    @Lob
    private String description;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSol() {
        return sol;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getSubTier() {
        return subTier;
    }

    public void setSubTier(String subTier) {
        this.subTier = subTier;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public LocalDate getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(LocalDate posteddate) {
        this.posteddate = posteddate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBasetype() {
        return basetype;
    }

    public void setBasetype(String basetype) {
        this.basetype = basetype;
    }

    public String getSetasidecode() {
        return setasidecode;
    }

    public void setSetasidecode(String setasidecode) {
        this.setasidecode = setasidecode;
    }

    public String getSetaside() {
        return setaside;
    }

    public void setSetaside(String setaside) {
        this.setaside = setaside;
    }

    public LocalDate getResponsedeadline() {
        return responsedeadline;
    }

    public void setResponsedeadline(LocalDate responsedeadline) {
        this.responsedeadline = responsedeadline;
    }

    public String getNaicscode() {
        return naicscode;
    }

    public void setNaicscode(String naicscode) {
        this.naicscode = naicscode;
    }

    public String getClassificationcode() {
        return classificationcode;
    }

    public void setClassificationcode(String classificationcode) {
        this.classificationcode = classificationcode;
    }

    public String getPopstate() {
        return popstate;
    }

    public void setPopstate(String popstate) {
        this.popstate = popstate;
    }

    public String getPopzip() {
        return popzip;
    }

    public void setPopzip(String popzip) {
        this.popzip = popzip;
    }

    public String getPopcountry() {
        return popcountry;
    }

    public void setPopcountry(String popcountry) {
        this.popcountry = popcountry;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(String organizationtype) {
        this.organizationtype = organizationtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContractOpportunityDTO)) {
            return false;
        }

        return id != null && id.equals(((ContractOpportunityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContractOpportunityDTO{" +
            "id=" + getId() +
            ", contractId='" + getContractId() + "'" +
            ", title='" + getTitle() + "'" +
            ", sol='" + getSol() + "'" +
            ", agency='" + getAgency() + "'" +
            ", subTier='" + getSubTier() + "'" +
            ", office='" + getOffice() + "'" +
            ", posteddate='" + getPosteddate() + "'" +
            ", type='" + getType() + "'" +
            ", basetype='" + getBasetype() + "'" +
            ", setasidecode='" + getSetasidecode() + "'" +
            ", setaside='" + getSetaside() + "'" +
            ", responsedeadline='" + getResponsedeadline() + "'" +
            ", naicscode='" + getNaicscode() + "'" +
            ", classificationcode='" + getClassificationcode() + "'" +
            ", popstate='" + getPopstate() + "'" +
            ", popzip='" + getPopzip() + "'" +
            ", popcountry='" + getPopcountry() + "'" +
            ", active='" + getActive() + "'" +
            ", organizationtype='" + getOrganizationtype() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
