package lab.ash.model.consent;

import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ConsentSectionOrder")
@SequenceGenerator(name = "ConsentSectionOrder_SEQUENCE", sequenceName = "ConsentSectionOrder_SEQ")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "rascalCache")
public class ConsentSectionOrder extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -1849360270316851488L;

    @JoinColumn(
            name = "consentHeader_id",
            nullable = false
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;

    public ConsentHeader getConsentHeader() {
        return this.consentHeader;
    }

    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }

    @Column(
            insertable = true,
            updatable = true,
            name = "oid",
            unique = true,
            nullable = false,
            precision = 24,
            scale = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "ConsentSectionOrder_SEQUENCE"
    )
    @Id
    private Long oid;

    @Override
    public Long getId() {
        return this.oid;
    }

    @Override
    protected void setId(Long oid) {
        this.oid = oid;
    }

    @Column(
            insertable = true,
            updatable = true,
            name = "sectionId"
    )
    private Integer sectionId;

    public Integer getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Column(
            insertable = true,
            updatable = true,
            name = "orderNumber"
    )
    private Integer orderNumber;

    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }


    public ConsentSectionOrder() {
    }

    public ConsentSectionOrder(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }

    public ConsentSectionOrder(Long oid, ConsentHeader consentHeader) {
        this.oid = oid;
        this.consentHeader = consentHeader;
    }

    public ConsentSectionOrder(Long oid, ConsentHeader consentHeader, Integer sectionId, Integer orderNumber) {
        this.oid = oid;
        this.consentHeader = consentHeader;
        this.orderNumber = orderNumber;
        this.sectionId = sectionId;
    }

}
