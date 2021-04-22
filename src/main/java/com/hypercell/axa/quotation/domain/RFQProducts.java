package com.hypercell.axa.quotation.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hypercell.axa.quotation.domain.enumeration.CoverType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A RFQProducts.
 */
@Entity
@Table(name = "rfq_products")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RFQProducts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rfq_id")
    private Long rfqId;

    @Column(name = "product_id")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "cover_type")
    private CoverType coverType;

    @OneToMany(mappedBy = "rFQProducts")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "rFQProductsItemsSections", "rFQProductsItemsValues", "rFQProducts" }, allowSetters = true)
    private Set<RFQProductsItems> rFQProductsItems = new HashSet<>();

    @OneToMany(mappedBy = "rFQProducts")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "rFQProducts" }, allowSetters = true)
    private Set<RFQProductsSections> rFQProductsSections = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "quotations", "rFQDocuments", "rFQProducts", "rFQProductsInfos" }, allowSetters = true)
    private RequestForQuotation requestForQuotation;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RFQProducts id(Long id) {
        this.id = id;
        return this;
    }

    public Long getRfqId() {
        return this.rfqId;
    }

    public RFQProducts rfqId(Long rfqId) {
        this.rfqId = rfqId;
        return this;
    }

    public void setRfqId(Long rfqId) {
        this.rfqId = rfqId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public RFQProducts productId(Long productId) {
        this.productId = productId;
        return this;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CoverType getCoverType() {
        return this.coverType;
    }

    public RFQProducts coverType(CoverType coverType) {
        this.coverType = coverType;
        return this;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public Set<RFQProductsItems> getRFQProductsItems() {
        return this.rFQProductsItems;
    }

    public RFQProducts rFQProductsItems(Set<RFQProductsItems> rFQProductsItems) {
        this.setRFQProductsItems(rFQProductsItems);
        return this;
    }

    public RFQProducts addRFQProductsItems(RFQProductsItems rFQProductsItems) {
        this.rFQProductsItems.add(rFQProductsItems);
        rFQProductsItems.setRFQProducts(this);
        return this;
    }

    public RFQProducts removeRFQProductsItems(RFQProductsItems rFQProductsItems) {
        this.rFQProductsItems.remove(rFQProductsItems);
        rFQProductsItems.setRFQProducts(null);
        return this;
    }

    public void setRFQProductsItems(Set<RFQProductsItems> rFQProductsItems) {
        if (this.rFQProductsItems != null) {
            this.rFQProductsItems.forEach(i -> i.setRFQProducts(null));
        }
        if (rFQProductsItems != null) {
            rFQProductsItems.forEach(i -> i.setRFQProducts(this));
        }
        this.rFQProductsItems = rFQProductsItems;
    }

    public Set<RFQProductsSections> getRFQProductsSections() {
        return this.rFQProductsSections;
    }

    public RFQProducts rFQProductsSections(Set<RFQProductsSections> rFQProductsSections) {
        this.setRFQProductsSections(rFQProductsSections);
        return this;
    }

    public RFQProducts addRFQProductsSections(RFQProductsSections rFQProductsSections) {
        this.rFQProductsSections.add(rFQProductsSections);
        rFQProductsSections.setRFQProducts(this);
        return this;
    }

    public RFQProducts removeRFQProductsSections(RFQProductsSections rFQProductsSections) {
        this.rFQProductsSections.remove(rFQProductsSections);
        rFQProductsSections.setRFQProducts(null);
        return this;
    }

    public void setRFQProductsSections(Set<RFQProductsSections> rFQProductsSections) {
        if (this.rFQProductsSections != null) {
            this.rFQProductsSections.forEach(i -> i.setRFQProducts(null));
        }
        if (rFQProductsSections != null) {
            rFQProductsSections.forEach(i -> i.setRFQProducts(this));
        }
        this.rFQProductsSections = rFQProductsSections;
    }

    public RequestForQuotation getRequestForQuotation() {
        return this.requestForQuotation;
    }

    public RFQProducts requestForQuotation(RequestForQuotation requestForQuotation) {
        this.setRequestForQuotation(requestForQuotation);
        return this;
    }

    public void setRequestForQuotation(RequestForQuotation requestForQuotation) {
        this.requestForQuotation = requestForQuotation;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RFQProducts)) {
            return false;
        }
        return id != null && id.equals(((RFQProducts) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RFQProducts{" +
            "id=" + getId() +
            ", rfqId=" + getRfqId() +
            ", productId=" + getProductId() +
            ", coverType='" + getCoverType() + "'" +
            "}";
    }
}
