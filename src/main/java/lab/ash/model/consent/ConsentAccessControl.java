package lab.ash.model.consent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ConsentAccessControl")
@SequenceGenerator(name = "ConsentAccessControl_SEQUENCE", sequenceName = "ConsentAccessControl_SEQ")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "rascalCache")
public class ConsentAccessControl extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -3547784551007158391L;

    @JoinColumn(name = "consentHeader_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;

    @JoinColumn(
            insertable = true,
            updatable = true,
            name = "rid",
            nullable = false, unique = true)
    @OneToOne(fetch = FetchType.EAGER)
    private RascalUser rascalUser;


    @Column(
            insertable = true,
            updatable = true,
            name = "editView",
            length = 10
    )
    private String editView;

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
            strategy = GenerationType.SEQUENCE, generator = "ConsentAccessControl_SEQUENCE"
    )
    @Id
    private Long oid;


    public ConsentAccessControl() {
    }

    public ConsentAccessControl(Long oid) {
        this.oid = oid;
    }

    public ConsentAccessControl(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }


    public ConsentHeader getConsentHeader() {
        return this.consentHeader;
    }

    public String getEditView() {
        return this.editView;
    }

    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }

    public void setEditView(String editView) {
        this.editView = editView;
    }

    @Override
    public Long getId() {
        return this.oid;
    }

    @Override
    protected void setId(Long oid) {
        this.oid = oid;

    }

    public RascalUser getRascalUser() {
        return rascalUser;
    }

    public void setRascalUser(RascalUser rascalUser) {
        this.rascalUser = rascalUser;
    }

}
