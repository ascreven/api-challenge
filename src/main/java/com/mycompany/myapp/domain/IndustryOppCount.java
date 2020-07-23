package com.mycompany.myapp.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.IndustryOppCount} entity.
 */
@Entity
@NamedNativeQuery(
    name = "get_opportunity_counts",
    query = "select * from get_opportunity_counts();",
    resultSetMapping = "industryCountMap"
)
@SqlResultSetMapping(
    name="industryCountMap",
    entities={
        @EntityResult(
           entityClass=IndustryOppCount.class,
              fields={
                  @FieldResult(name="id", column="id"),
                  @FieldResult(name="code", column="code"),
                  @FieldResult(name="title", column="title"),
                  @FieldResult(name="opportunities", column="opportunities")
              }         
        )
    }
) 
public class IndustryOppCount implements Serializable {

    private static final long serialVersionUID = 1L;

    public IndustryOppCount() {}

    public IndustryOppCount(Long id, String code, String title, Long opportunities) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.opportunities = opportunities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String code;

    @Size(max = 1024)
    private String title;

    private Long opportunities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String naicsCode) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Long oppCount) {
        this.opportunities = opportunities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IndustryOppCount)) {
            return false;
        }

        return code != null && code.equals(((IndustryOppCount) o).code);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IndustryOppCount {" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", title='" + getTitle() + "'" +
            "opportunities=" + getOpportunities() +
            "}";
    }
}
