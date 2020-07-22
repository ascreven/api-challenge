package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Custom class
 */
public class IndustryOppCountCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter parentCode;

    private StringFilter setAside;

    private StringFilter keywords;

    public IndustryOppCountCriteria() {
    }

    public IndustryOppCountCriteria(IndustryOppCountCriteria other) {
        this.parentCode = other.parentCode == null ? null : other.parentCode.copy();
        this.setAside = other.setAside == null ? null : other.setAside.copy();
        this.keywords = other.keywords == null ? null : other.keywords.copy();
    }

    @Override
    public IndustryOppCountCriteria copy() {
        return new IndustryOppCountCriteria(this);
    }

    public StringFilter getParentCode() {
        return parentCode;
    }

    public void setParentCode(StringFilter parentCode) {
        this.parentCode = parentCode;
    }

    public StringFilter getSetAside() {
        return setAside;
    }

    public void setSetAside(StringFilter setAside) {
        this.setAside = setAside;
    }

    public StringFilter getKeywords() {
        return keywords;
    }

    public void setKeywords(StringFilter keywords) {
        this.keywords = keywords;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IndustryOppCountCriteria that = (IndustryOppCountCriteria) o;
        return
            Objects.equals(parentCode, that.parentCode) &&
            Objects.equals(setAside, that.setAside) &&
            Objects.equals(keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        parentCode,
        setAside,
        keywords);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContractOpportunityCriteria{" +
                (parentCode != null ? "parentCode=" + parentCode + ", " : "") +
                (setAside != null ? "setAside=" + setAside + ", " : "") +
                (keywords != null ? "keywords=" + keywords + ", " : "") +
            "}";
    }

}
