package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.*;


public class IndustryOppCountDTO implements Serializable {

    private String naicsCode;

    @Size(max = 1024)
    private String title;

    private Long oppCount;

    
    public Long getOppCount() {
        return oppCount;
    }

    public void setOppCount(Long oppCount) {
        this.oppCount = oppCount;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IndustryOppCountDTO)) {
            return false;
        }

        return naicsCode != null && naicsCode.equals(((IndustryOppCountDTO) o).naicsCode);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IndustryOppCountsDTO{" +
            "oppCount=" + getOppCount() +
            ", naicsCode='" + getNaicsCode() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }
}
