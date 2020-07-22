package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.ContractOpportunity} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.ContractOpportunityResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /contract-opportunities?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ContractOpportunityCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter contractId;

    private StringFilter title;

    private StringFilter sol;

    private StringFilter agency;

    private StringFilter subTier;

    private StringFilter office;

    private LocalDateFilter posteddate;

    private StringFilter type;

    private StringFilter basetype;

    private StringFilter setasidecode;

    private StringFilter setaside;

    private LocalDateFilter responsedeadline;

    private StringFilter naicscode;

    private StringFilter classificationcode;

    private StringFilter popstate;

    private StringFilter popzip;

    private StringFilter popcountry;

    private StringFilter active;

    private StringFilter organizationtype;

    public ContractOpportunityCriteria() {
    }

    public ContractOpportunityCriteria(ContractOpportunityCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.contractId = other.contractId == null ? null : other.contractId.copy();
        this.title = other.title == null ? null : other.title.copy();
        this.sol = other.sol == null ? null : other.sol.copy();
        this.agency = other.agency == null ? null : other.agency.copy();
        this.subTier = other.subTier == null ? null : other.subTier.copy();
        this.office = other.office == null ? null : other.office.copy();
        this.posteddate = other.posteddate == null ? null : other.posteddate.copy();
        this.type = other.type == null ? null : other.type.copy();
        this.basetype = other.basetype == null ? null : other.basetype.copy();
        this.setasidecode = other.setasidecode == null ? null : other.setasidecode.copy();
        this.setaside = other.setaside == null ? null : other.setaside.copy();
        this.responsedeadline = other.responsedeadline == null ? null : other.responsedeadline.copy();
        this.naicscode = other.naicscode == null ? null : other.naicscode.copy();
        this.classificationcode = other.classificationcode == null ? null : other.classificationcode.copy();
        this.popstate = other.popstate == null ? null : other.popstate.copy();
        this.popzip = other.popzip == null ? null : other.popzip.copy();
        this.popcountry = other.popcountry == null ? null : other.popcountry.copy();
        this.active = other.active == null ? null : other.active.copy();
        this.organizationtype = other.organizationtype == null ? null : other.organizationtype.copy();
    }

    @Override
    public ContractOpportunityCriteria copy() {
        return new ContractOpportunityCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getContractId() {
        return contractId;
    }

    public void setContractId(StringFilter contractId) {
        this.contractId = contractId;
    }

    public StringFilter getTitle() {
        return title;
    }

    public void setTitle(StringFilter title) {
        this.title = title;
    }

    public StringFilter getSol() {
        return sol;
    }

    public void setSol(StringFilter sol) {
        this.sol = sol;
    }

    public StringFilter getAgency() {
        return agency;
    }

    public void setAgency(StringFilter agency) {
        this.agency = agency;
    }

    public StringFilter getSubTier() {
        return subTier;
    }

    public void setSubTier(StringFilter subTier) {
        this.subTier = subTier;
    }

    public StringFilter getOffice() {
        return office;
    }

    public void setOffice(StringFilter office) {
        this.office = office;
    }

    public LocalDateFilter getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(LocalDateFilter posteddate) {
        this.posteddate = posteddate;
    }

    public StringFilter getType() {
        return type;
    }

    public void setType(StringFilter type) {
        this.type = type;
    }

    public StringFilter getBasetype() {
        return basetype;
    }

    public void setBasetype(StringFilter basetype) {
        this.basetype = basetype;
    }

    public StringFilter getSetasidecode() {
        return setasidecode;
    }

    public void setSetasidecode(StringFilter setasidecode) {
        this.setasidecode = setasidecode;
    }

    public StringFilter getSetaside() {
        return setaside;
    }

    public void setSetaside(StringFilter setaside) {
        this.setaside = setaside;
    }

    public LocalDateFilter getResponsedeadline() {
        return responsedeadline;
    }

    public void setResponsedeadline(LocalDateFilter responsedeadline) {
        this.responsedeadline = responsedeadline;
    }

    public StringFilter getNaicscode() {
        return naicscode;
    }

    public void setNaicscode(StringFilter naicscode) {
        this.naicscode = naicscode;
    }

    public StringFilter getClassificationcode() {
        return classificationcode;
    }

    public void setClassificationcode(StringFilter classificationcode) {
        this.classificationcode = classificationcode;
    }

    public StringFilter getPopstate() {
        return popstate;
    }

    public void setPopstate(StringFilter popstate) {
        this.popstate = popstate;
    }

    public StringFilter getPopzip() {
        return popzip;
    }

    public void setPopzip(StringFilter popzip) {
        this.popzip = popzip;
    }

    public StringFilter getPopcountry() {
        return popcountry;
    }

    public void setPopcountry(StringFilter popcountry) {
        this.popcountry = popcountry;
    }

    public StringFilter getActive() {
        return active;
    }

    public void setActive(StringFilter active) {
        this.active = active;
    }

    public StringFilter getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(StringFilter organizationtype) {
        this.organizationtype = organizationtype;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ContractOpportunityCriteria that = (ContractOpportunityCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(contractId, that.contractId) &&
            Objects.equals(title, that.title) &&
            Objects.equals(sol, that.sol) &&
            Objects.equals(agency, that.agency) &&
            Objects.equals(subTier, that.subTier) &&
            Objects.equals(office, that.office) &&
            Objects.equals(posteddate, that.posteddate) &&
            Objects.equals(type, that.type) &&
            Objects.equals(basetype, that.basetype) &&
            Objects.equals(setasidecode, that.setasidecode) &&
            Objects.equals(setaside, that.setaside) &&
            Objects.equals(responsedeadline, that.responsedeadline) &&
            Objects.equals(naicscode, that.naicscode) &&
            Objects.equals(classificationcode, that.classificationcode) &&
            Objects.equals(popstate, that.popstate) &&
            Objects.equals(popzip, that.popzip) &&
            Objects.equals(popcountry, that.popcountry) &&
            Objects.equals(active, that.active) &&
            Objects.equals(organizationtype, that.organizationtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        contractId,
        title,
        sol,
        agency,
        subTier,
        office,
        posteddate,
        type,
        basetype,
        setasidecode,
        setaside,
        responsedeadline,
        naicscode,
        classificationcode,
        popstate,
        popzip,
        popcountry,
        active,
        organizationtype
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContractOpportunityCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (contractId != null ? "contractId=" + contractId + ", " : "") +
                (title != null ? "title=" + title + ", " : "") +
                (sol != null ? "sol=" + sol + ", " : "") +
                (agency != null ? "agency=" + agency + ", " : "") +
                (subTier != null ? "subTier=" + subTier + ", " : "") +
                (office != null ? "office=" + office + ", " : "") +
                (posteddate != null ? "posteddate=" + posteddate + ", " : "") +
                (type != null ? "type=" + type + ", " : "") +
                (basetype != null ? "basetype=" + basetype + ", " : "") +
                (setasidecode != null ? "setasidecode=" + setasidecode + ", " : "") +
                (setaside != null ? "setaside=" + setaside + ", " : "") +
                (responsedeadline != null ? "responsedeadline=" + responsedeadline + ", " : "") +
                (naicscode != null ? "naicscode=" + naicscode + ", " : "") +
                (classificationcode != null ? "classificationcode=" + classificationcode + ", " : "") +
                (popstate != null ? "popstate=" + popstate + ", " : "") +
                (popzip != null ? "popzip=" + popzip + ", " : "") +
                (popcountry != null ? "popcountry=" + popcountry + ", " : "") +
                (active != null ? "active=" + active + ", " : "") +
                (organizationtype != null ? "organizationtype=" + organizationtype + ", " : "") +
            "}";
    }

}
