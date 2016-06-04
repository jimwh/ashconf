package lab.ash.model.consent;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lab.ash.model.AbstractPersistable;
import lab.ash.model.BlobEntity;



@Entity
@Table(name = "ConsentSnapshot", uniqueConstraints = @UniqueConstraint(columnNames = "oid"))
@SequenceGenerator(name = "ConsentSnapshot_SEQUENCE", sequenceName = "ConsentSnapshot_SEQ")
public class ConsentSnapshot extends AbstractPersistable<Long> implements BlobEntity {

    private static final long serialVersionUID = 7830317041623089697L;

    @Column(name = "oid", unique = true, nullable = false, precision = 24)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConsentSnapshot_SEQUENCE")
    @Id
    private Long oid;//NOPMD

    @JoinColumn(name = "ConsentHeaderOid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;

    @Column(name = "creationDate", length = 23)
    @Temporal(TemporalType.TIMESTAMP)
    private final Date creationDate;//NOPMD

    @Basic(fetch = FetchType.LAZY)
    @Column(updatable = false, name = "fileContext")
    @Lob
    private Blob fileContext;//NOPMD

    public ConsentSnapshot() {
        super();
        this.creationDate = new Date();
    }

    @Override
    public Long getId() {
        return oid;
    }
    @Override
    protected void setId(final Long headerId) {
        this.oid = headerId;
    }

    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    public ConsentHeader getConsentHeader() {
        return consentHeader;
    }
    public void setConsentHeader(final ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }

    @Override
    public Blob getBlob() {
        return this.fileContext;
    }

    @Override
    public void setBlob(final Blob blob) {
        this.fileContext = blob;
    }

    public void setFileContext(final Blob blob) {
        this.setBlob(blob);
    }

    public Blob getFileContext() {
        return this.getBlob();
    }

}
