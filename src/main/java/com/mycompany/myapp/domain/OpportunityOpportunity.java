package com.mycompany.myapp.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A OpportunityOpportunity.
 */
@Entity
@Table(name = "opportunity_opportunity")
public class OpportunityOpportunity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "contract_id")
    private String contractId;

    @Size(max = 1024)
    @Column(name = "title", length = 1024)
    private String title;

    @Column(name = "sol")
    private String sol;

    @Column(name = "agency")
    private String agency;

    @Column(name = "sub_tier")
    private String subTier;

    @Column(name = "office")
    private String office;

    @Column(name = "posteddate")
    private LocalDate posteddate;

    @Column(name = "type")
    private String type;

    @Column(name = "basetype")
    private String basetype;

    @Column(name = "setasidecode")
    private String setasidecode;

    @Column(name = "setaside")
    private String setaside;

    @Column(name = "responsedeadline")
    private LocalDate responsedeadline;

    @Column(name = "naicscode")
    private String naicscode;

    @Column(name = "classificationcode")
    private String classificationcode;

    @Column(name = "popstate")
    private String popstate;

    @Column(name = "popzip")
    private String popzip;

    @Column(name = "popcountry")
    private String popcountry;

    @Column(name = "active")
    private String active;

    @Column(name = "organizationtype")
    private String organizationtype;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "description")
    private String description;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public OpportunityOpportunity contractId(String contractId) {
        this.contractId = contractId;
        return this;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getTitle() {
        return title;
    }

    public OpportunityOpportunity title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSol() {
        return sol;
    }

    public OpportunityOpportunity sol(String sol) {
        this.sol = sol;
        return this;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public String getAgency() {
        return agency;
    }

    public OpportunityOpportunity agency(String agency) {
        this.agency = agency;
        return this;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getSubTier() {
        return subTier;
    }

    public OpportunityOpportunity subTier(String subTier) {
        this.subTier = subTier;
        return this;
    }

    public void setSubTier(String subTier) {
        this.subTier = subTier;
    }

    public String getOffice() {
        return office;
    }

    public OpportunityOpportunity office(String office) {
        this.office = office;
        return this;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public LocalDate getPosteddate() {
        return posteddate;
    }

    public OpportunityOpportunity posteddate(LocalDate posteddate) {
        this.posteddate = posteddate;
        return this;
    }

    public void setPosteddate(LocalDate posteddate) {
        this.posteddate = posteddate;
    }

    public String getType() {
        return type;
    }

    public OpportunityOpportunity type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBasetype() {
        return basetype;
    }

    public OpportunityOpportunity basetype(String basetype) {
        this.basetype = basetype;
        return this;
    }

    public void setBasetype(String basetype) {
        this.basetype = basetype;
    }

    public String getSetasidecode() {
        return setasidecode;
    }

    public OpportunityOpportunity setasidecode(String setasidecode) {
        this.setasidecode = setasidecode;
        return this;
    }

    public void setSetasidecode(String setasidecode) {
        this.setasidecode = setasidecode;
    }

    public String getSetaside() {
        return setaside;
    }

    public OpportunityOpportunity setaside(String setaside) {
        this.setaside = setaside;
        return this;
    }

    public void setSetaside(String setaside) {
        this.setaside = setaside;
    }

    public LocalDate getResponsedeadline() {
        return responsedeadline;
    }

    public OpportunityOpportunity responsedeadline(LocalDate responsedeadline) {
        this.responsedeadline = responsedeadline;
        return this;
    }

    public void setResponsedeadline(LocalDate responsedeadline) {
        this.responsedeadline = responsedeadline;
    }

    public String getNaicscode() {
        return naicscode;
    }

    public OpportunityOpportunity naicscode(String naicscode) {
        this.naicscode = naicscode;
        return this;
    }

    public void setNaicscode(String naicscode) {
        this.naicscode = naicscode;
    }

    public String getClassificationcode() {
        return classificationcode;
    }

    public OpportunityOpportunity classificationcode(String classificationcode) {
        this.classificationcode = classificationcode;
        return this;
    }

    public void setClassificationcode(String classificationcode) {
        this.classificationcode = classificationcode;
    }

    public String getPopstate() {
        return popstate;
    }

    public OpportunityOpportunity popstate(String popstate) {
        this.popstate = popstate;
        return this;
    }

    public void setPopstate(String popstate) {
        this.popstate = popstate;
    }

    public String getPopzip() {
        return popzip;
    }

    public OpportunityOpportunity popzip(String popzip) {
        this.popzip = popzip;
        return this;
    }

    public void setPopzip(String popzip) {
        this.popzip = popzip;
    }

    public String getPopcountry() {
        return popcountry;
    }

    public OpportunityOpportunity popcountry(String popcountry) {
        this.popcountry = popcountry;
        return this;
    }

    public void setPopcountry(String popcountry) {
        this.popcountry = popcountry;
    }

    public String getActive() {
        return active;
    }

    public OpportunityOpportunity active(String active) {
        this.active = active;
        return this;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getOrganizationtype() {
        return organizationtype;
    }

    public OpportunityOpportunity organizationtype(String organizationtype) {
        this.organizationtype = organizationtype;
        return this;
    }

    public void setOrganizationtype(String organizationtype) {
        this.organizationtype = organizationtype;
    }

    public String getDescription() {
        return description;
    }

    public OpportunityOpportunity description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpportunityOpportunity)) {
            return false;
        }
        return id != null && id.equals(((OpportunityOpportunity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OpportunityOpportunity{" +
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
